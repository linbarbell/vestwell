package vestwell;

import java.util.ArrayList;
import java.util.List;

import static vestwell.Constants.*;

public class Chamber {
    private final String init;

    public Chamber(String init) {
        this.init = init;
    }

    public String[] animate(int speed) {
        List<String> positions = new ArrayList<>();
        List<List<Character>> particles = new ArrayList<>(init.length()); // list of particles at each position
        boolean particlesRemain = false;

        for (char c: init.toCharArray()) { // initialize the particles
            List<Character> chars = new ArrayList<>();
            if (c != EMPTY) {
                chars.add(c);
                particlesRemain = true;
            }
            particles.add(chars);
        }
        positions.add(getPosition(particles));

        while (particlesRemain) { // while particles remain, calculate the new particle positions
            List<List<Character>> newParticles = new ArrayList<>(init.length());
            for (int i = 0; i < init.length(); i++) {
                newParticles.add(new ArrayList<>());
            }

            for (int i = 0; i < init.length(); i++) {
                List<Character> curr = particles.get(i);
                if (curr == null || curr.isEmpty()) continue;
                for (char particle : curr) {
                    int pos = particle == L ? i - speed : i + speed;
                    if (pos >= 0 && pos < init.length()) {
                        newParticles.get(pos).add(particle);
                    }
                }
            }
            particles = newParticles;

            positions.add(getPosition(particles));
            particlesRemain = particles.stream().anyMatch(i -> !i.isEmpty());
        }
        return positions.toArray(new String[0]);
    }

    private String getPosition(List<List<Character>> particles) {
        char[] position = new char[init.length()];
        for (int i = 0; i < init.length(); i++) {
            position[i] = particles.get(i).isEmpty() ? EMPTY : X;
        }
        return new String(position);
    }
}

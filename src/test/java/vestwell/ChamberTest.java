package vestwell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ChamberTest {

    @Test
    public void test0() {
        String[] expected = new String[] {
            "..X...." ,
            "....X..",
            "......X",
            "......."
        };
        assertArrayEquals(expected, new Chamber("..R....").animate(2));
    }

    @Test
    public void test1() {
        String[] expected = new String[] {
                "XX..XXX",
                ".X.XX..",
                "X.....X",
                "......."
        };
        assertArrayEquals(expected, new Chamber("RR..LRL").animate(3));
    }

    @Test
    public void test2() {
        String[] expected = new String[] {
                "XXXX.XXXX",
                "X..X.X..X",
                ".X.X.X.X.",
                ".X.....X.",
                "........."
        };
        assertArrayEquals(expected, new Chamber("LRLR.LRLR").animate(2));
    }

    @Test
    public void test3() {
        String[] expected = new String[] {
                "XXXXXXXXXX",
                ".........."
        };
        assertArrayEquals(expected, new Chamber("RLRLRLRLRL").animate(10));
    }

    @Test
    public void test4() {
        String[] expected = new String[] {
                "..."
        };
        assertArrayEquals(expected, new Chamber("...").animate(1));
    }

    @Test
    public void test5() {
        String[] expected = new String[] {
                "XXXX.XX.XXX.X.XXXX.",
                "..XXX..X..XX.X..XX.",
                ".X.XX.X.X..XX.XX.XX",
                "X.X.XX...X.XXXXX..X",
                ".X..XXX...X..XX.X..",
                "X..X..XX.X.XX.XX.X.",
                "..X....XX..XX..XX.X",
                ".X.....XXXX..X..XX.",
                "X.....X..XX...X..XX",
                ".....X..X.XX...X..X",
                "....X..X...XX...X..",
                "...X..X.....XX...X.",
                "..X..X.......XX...X",
                ".X..X.........XX...",
                "X..X...........XX..",
                "..X.............XX.",
                ".X...............XX",
                "X.................X",
                "..................."
        };
        assertArrayEquals(expected, new Chamber("LRRL.LR.LRR.R.LRRL.").animate(1));
    }

    @Test
    public void test6() {
        String[] expected = new String[] { "XX", "XX", ".." };
        assertArrayEquals(expected, new Chamber("RL").animate(1));
    }
}

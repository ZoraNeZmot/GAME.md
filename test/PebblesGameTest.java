import org.junit.Test;
import static org.junit.Assert.*;

public class PebblesGameTest {

    @Test
    public void testWinningPositions() {
        assertTrue(PebblesGame.isWinningPosition(1));
        assertTrue(PebblesGame.isWinningPosition(2));
        assertTrue(PebblesGame.isWinningPosition(3));
        assertTrue(PebblesGame.isWinningPosition(5));
        assertTrue(PebblesGame.isWinningPosition(6));
        assertTrue(PebblesGame.isWinningPosition(7));
        assertTrue(PebblesGame.isWinningPosition(9));
        assertTrue(PebblesGame.isWinningPosition(10));
        assertTrue(PebblesGame.isWinningPosition(11));
        assertTrue(PebblesGame.isWinningPosition(17));
    }

    @Test
    public void testLosingPositions() {
        assertFalse(PebblesGame.isWinningPosition(0));
        assertFalse(PebblesGame.isWinningPosition(4));
        assertFalse(PebblesGame.isWinningPosition(8));
        assertFalse(PebblesGame.isWinningPosition(12));
        assertFalse(PebblesGame.isWinningPosition(20));
    }

    @Test
    public void testWinningMoves() {
        assertEquals(1, PebblesGame.findWinningMove(1));
        assertEquals(2, PebblesGame.findWinningMove(2));
        assertEquals(3, PebblesGame.findWinningMove(3));
        assertEquals(1, PebblesGame.findWinningMove(5));
        assertEquals(2, PebblesGame.findWinningMove(6));
        assertEquals(3, PebblesGame.findWinningMove(7));
        assertEquals(1, PebblesGame.findWinningMove(9));
        assertEquals(2, PebblesGame.findWinningMove(10));
        assertEquals(3, PebblesGame.findWinningMove(11));
        assertEquals(1, PebblesGame.findWinningMove(17));
    }

    @Test
    public void testNoWinningMove() {
        assertEquals(-1, PebblesGame.findWinningMove(0));
        assertEquals(-1, PebblesGame.findWinningMove(4));
        assertEquals(-1, PebblesGame.findWinningMove(8));
        assertEquals(-1, PebblesGame.findWinningMove(12));
        assertEquals(-1, PebblesGame.findWinningMove(20));
    }
}
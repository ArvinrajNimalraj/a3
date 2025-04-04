package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest {
    @Test
    void getCanonicalForm() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");

        assertEquals("F L FFFFF R FF R FF L FFFFFF R FFFF L F", path.getCanonicalForm());
    }

    @Test
    void getFactorizedForm() {
        Path path = new Path("FLFFFFFRFFRFFLFFFFFFRFFFFLF");

        assertEquals("F L 5F R 2F R 2F L 6F R 4F L F", path.getFactorizedForm());
    }

    @Test
    void expandedPath() {
        Path path = new Path("4F 3R L");

        assertEquals("FFFF RRR L", path.getCanonicalForm());
    }


    @Test
    void expandedPath2() {
        Path path = new Path("10F 11R");

        assertEquals("FFFFFFFFFF RRRRRRRRRRR", path.getCanonicalForm());
    }

    @Test
    void testFactorizedFormWithRepeatingSteps() {
        Path path = new Path("FFFLLLRRR");
        assertEquals("3F 3L 3R", path.getFactorizedForm());
    }

    @Test
    void testCanonicalFormWithSpacesBetweenSteps() {
        Path path = new Path("F L R F L R");
        assertEquals("F L R F L R", path.getCanonicalForm());
    }

    @Test
    void testExpandPathWithMultipleDigits() {
        Path path = new Path("12F 5R 3L");
        assertEquals("FFFFFFFFFFFF RRRRR LLL", path.getCanonicalForm());
    }
    
    @Test
    void testFactorizedFormEmptyPath() {
        Path path = new Path(""); // Empty path input
        assertEquals("", path.getFactorizedForm());
    }

    @Test
    void testInvalidFactorizedPath() {
        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            new Path("F2"); // Factorization missing character
    });
    assertNotNull(exception);
    }

    @Test
    void testPathExpansionWithComplexInput() {
        Path path = new Path("3F 2L R 4F 2R");
        assertEquals("FFF LL R FFFF RR", path.getCanonicalForm());
    }

}

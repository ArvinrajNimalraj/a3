import ca.mcmaster.se2aa4.mazerunner.Path;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    @Test
    public void testExpandFactorizedStringPathSimple() {
        Path path = new Path();
        String expanded = path.expandFactorizedStringPath("2F3L");
        assertEquals("FFLLL", expanded);
    }

    @Test
    public void testExpandFactorizedStringPathWithSingleStep() {
        Path path = new Path();
        String expanded = path.expandFactorizedStringPath("F");
        assertEquals("F", expanded);
    }

    @Test
    public void testExpandFactorizedStringPathWithMixedSteps() {
        Path path = new Path();
        String expanded = path.expandFactorizedStringPath("F2L3R");
        assertEquals("FLLRRR", expanded);
    }

    @Test
    public void testAddStep() {
        Path path = new Path();
        path.addStep('F');
        path.addStep('L');
        assertEquals(List.of('F', 'L'), path.getPathSteps());
    }

    @Test
    public void testGetCanonicalForm() {
        Path path = new Path("FF LL RRR");
        String canonical = path.getCanonicalForm();
        assertEquals("FF LL RRR", canonical);
    }

    @Test
    public void testGetFactorizedForm() {
        Path path = new Path("FF LL RRR");
        String factorized = path.getFactorizedForm();
        assertEquals("2F 2L 3R", factorized);
    }

    @Test
    public void testEmptyPathSteps() {
        Path path = new Path();
        List<Character> steps = path.getPathSteps();
        assertTrue(steps.isEmpty());
    }

    @Test
    public void testInvalidStepInPathString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Path("FFZ");
        });
        assertEquals("IOnstruction 'Z' is invalid. Must be 'F', 'L', or 'R'.", exception.getMessage());
    }

    @Test
    public void testInvalidFactorization() {
        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            new Path("10");
        });
        assertNotNull(exception);
    }

    @Test
    public void testPathExpansionWithSpaces() {
        Path path = new Path("3F 2L");
        String expanded = path.expandFactorizedStringPath("3F 2L");
        assertEquals("FFFL L", expanded);
    }
}


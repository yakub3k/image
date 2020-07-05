package yakub.normalize.algorithms;

import org.junit.Test;
import yakub.normalize.NormalizeTest;

import static org.junit.Assert.*;

public class ScaleAlgorithmTest {

    private ScaleAlgorithm algorithm = (value, scale, max) -> value * scale / max;

    @Test
    public void normalizeBasic() {
        int[] normalize = algorithm.normalize(NormalizeTest.BASIC_INT_ARRAY);

        assertArrayEquals(new int[]{42, 85, 127, 170, 212, 255}, normalize);
    }

    @Test
    public void normalizeOnce() {
        int[] normalize = algorithm.normalize(NormalizeTest.ONES_INT_ARRAY);

        assertArrayEquals(new int[]{255, 255, 255, 255, 255, 255}, normalize);
    }

    @Test(expected = IllegalStateException.class)
    public void normalizeInvalidState() {
        algorithm.normalize(NormalizeTest.INVALID_INT_ARRAY);
    }
}
package yakub.normalize.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinearTest {

    private Linear algorithm = new Linear();

    @Test
    public void rescaleMax() {
        int normalized = algorithm.rescale(10, 255, 10);

        assertEquals(255, normalized);
    }

    @Test
    public void rescaleMaxHigh() {
        int normalized = algorithm.rescale(65535, 255, 65535);

        assertEquals(255, normalized);
    }

    @Test
    public void rescaleHalf() {
        int normalized = algorithm.rescale(5, 255, 10);

        assertEquals(127, normalized);
    }

    @Test
    public void rescaleMin() {
        int normalized = algorithm.rescale(0, 255, 10);

        assertEquals(0, normalized);
    }

    @Test
    public void rescaleMinHigh() {
        int normalized = algorithm.rescale(0, 255, 65535);

        assertEquals(0, normalized);
    }

    @Test
    public void rescaleMinHalfOfHigh() {
        int normalized = algorithm.rescale(32767, 255, 65535);

        assertEquals(127, normalized);
    }
}
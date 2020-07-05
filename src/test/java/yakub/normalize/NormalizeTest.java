package yakub.normalize;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalizeTest {

    public static final int[] BASIC_INT_ARRAY = {1, 2, 3, 4, 5, 6};
    public static final int[] ONES_INT_ARRAY = {1, 1, 1, 1, 1, 1};
    public static final int[] INVALID_INT_ARRAY = {-1, -1, -1, -1, -1, -1};
    public static final int[] WITH_NEGATIVE_INT_ARRAY = {0, -1, 0, -1};

    @Test
    public void max() {
        int max = Normalize.max(BASIC_INT_ARRAY);

        assertEquals(6, max);
    }

    @Test
    public void maxWithNegative() {
        int max = Normalize.max(WITH_NEGATIVE_INT_ARRAY);

        assertEquals(1, max);
    }

    @Test(expected = IllegalStateException.class)
    public void maxInvalid() {
        Normalize.max(INVALID_INT_ARRAY);

    }

    @Test
    public void maxSome() {
        int max = Normalize.max(ONES_INT_ARRAY);

        assertEquals(1, max);
    }

    @Test
    public void maxZero() {
        int max = Normalize.max(new int[]{0, 0, 0});

        assertEquals(1, max);
    }
}
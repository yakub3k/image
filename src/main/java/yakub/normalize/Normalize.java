package yakub.normalize;

public final class Normalize {

    public static int max(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int value : input) {
            if (max < value) {
                max = value;
            }
        }

        if (max < 0) {
            throw new IllegalStateException("Max value is to low: " + max);
        }

        if (max == 0) {
            return 1;
        }

        return max;
    }

    private Normalize() {
    }
}

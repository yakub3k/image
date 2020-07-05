package yakub.normalize.algorithms;

import yakub.normalize.Normalize;

public interface ScaleAlgorithm {

    int DEFAULT_SCALE = 255;


    int rescale(int value, int scale, int max);


    default int[] normalize(int[] input) {
        return normalize(input, DEFAULT_SCALE);
    }

    default int[] normalize(int[] input, int scale) {
        return normalize(input, scale, Normalize.max(input));
    }

    default int[] normalize(final int[] input, int scale, int max) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = rescale(input[i], scale, max);
        }

        if (max < 0) {
            throw new IllegalStateException("Max value is to low: " + max);
        }

        return result;
    }
}

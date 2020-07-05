package yakub.normalize.algorithms;

public class Linear implements ScaleAlgorithm {

    @Override
    public int rescale(int value, int scale, int max) {
        return value * scale / max;
    }
}

package yakub.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yakub.normalize.algorithms.ScaleAlgorithm;

import java.awt.image.BufferedImage;
import java.util.function.IntUnaryOperator;

public class ColorLevel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorLevel.class);

    private final BufferedImage image;

    private final ScaleAlgorithm linear;


    public ColorLevel(BufferedImage image, ScaleAlgorithm algorithm) {
        this.image = image;
        this.linear = algorithm;
    }

    protected int[] getRedHistogram() {
        return getColorHistogram(this::getRed);
    }

    protected int[] getGreenHistogram() {
        return getColorHistogram(this::getGreen);
    }

    protected int[] getBlueHistogram() {
        return getColorHistogram(this::getBlue);
    }


    protected int[] getColorHistogram(IntUnaryOperator getColor) {
        LOGGER.info("Prepare histogram");
        int width = image.getWidth();
        int height = image.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int sRgb = image.getRGB(x, y);
                int color = getColor.applyAsInt(sRgb);
                histogram[color]++;
            }
        }

        return linear.normalize(histogram);
    }

    public int getRed(int sRgb) {
        return (sRgb & 0x00ff0000) >> 16;
    }

    public int getGreen(int sRgb) {
        return (sRgb & 0x0000ff00) >> 8;
    }

    public int getBlue(int sRgb) {
        return sRgb & 0x000000ff;
    }
}

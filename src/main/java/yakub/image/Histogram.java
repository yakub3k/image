package yakub.image;


import yakub.normalize.algorithms.Linear;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Histogram {

    private final BufferedImage image;

    public Histogram(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage histogram() {
        ColorLevel colorLevel = new ColorLevel(image, new Linear());
        int[] blueHistogram = colorLevel.getBlueHistogram();
        int[] greenHistogram = colorLevel.getGreenHistogram();
        int[] redHistogram = colorLevel.getRedHistogram();

        BufferedImage chart = new BufferedImage(256, 256, image.getType());

        for (int i = 0; i < 255; i++) {
            chart.setRGB(i, blueHistogram[i], Color.BLUE.getRGB());
            chart.setRGB(i, greenHistogram[i], Color.GREEN.getRGB());
            chart.setRGB(i, redHistogram[i], Color.RED.getRGB());
        }
        chart.flush();

        return chart;
    }
}

package yakub.image;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import yakub.normalize.algorithms.Linear;

import java.awt.image.BufferedImage;
import java.util.Arrays;


public class ColorLevelTest {

    public static final int HISTOGRAM_LENGTH = 256;
    private static BufferedImage image;
    private static Linear algorithm;

    @BeforeClass
    public static void beforeClass() throws Exception {
        image = new OpenImage(OpenImageTest.TARGET_CLASSES_PATH, OpenImageTest.NO_PASS_PNG)
                .getBufferedImage();
        algorithm = new Linear();
    }

    @Test
    public void redHistogram() {
        int[] redHistogram = new ColorLevel(image, algorithm).getRedHistogram();

        Assertions.assertEquals(256, redHistogram.length, "Histogram size");
        Arrays.stream(redHistogram)
                .forEach(color ->
                        Assertions.assertTrue(color >= 0));
    }

    @Test
    public void blueHistogram() {
        int[] redHistogram = new ColorLevel(image, new Linear()).getBlueHistogram();

        Assertions.assertEquals(256, redHistogram.length, "Histogram size");
        Arrays.stream(redHistogram)
                .forEach(color ->
                        Assertions.assertTrue(color >= 0));
    }

    @Test
    public void greenHistogram() {
        int[] redHistogram = new ColorLevel(image, new Linear()).getGreenHistogram();

        Assertions.assertEquals(HISTOGRAM_LENGTH, redHistogram.length, "Histogram size");
        Arrays.stream(redHistogram)
                .forEach(color ->
                        Assertions.assertTrue(color >= 0));
    }
}
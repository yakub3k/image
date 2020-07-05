package yakub.image;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenImageTest {

    public static final String TARGET_CLASSES_PATH = "target/classes/";
    public static final String NO_PASS_PNG = "no_pass.png";


    @Test
    public void incorrectPath() {
        boolean correct = new OpenImage("", "not.exist").isCorrect();

        assertFalse(correct);
    }

    @Test
    public void correctPath() {
        boolean correct = new OpenImage(TARGET_CLASSES_PATH, "test.txt").isCorrect();

        assertTrue(correct);
    }

    @Test
    public void isImage() throws Exception {
        boolean isImage = new OpenImage(TARGET_CLASSES_PATH, NO_PASS_PNG).isImage();

        assertTrue(isImage);
    }

    @Test
    public void contentType() throws Exception {
        OpenImage image = new OpenImage(TARGET_CLASSES_PATH, NO_PASS_PNG);

        String contentType = image.getContentType();

        assertEquals("image/png", contentType);
    }

    @Test
    public void invalidBufferedImage() throws Exception {
        OpenImage image = new OpenImage(TARGET_CLASSES_PATH, "test.txt");

        BufferedImage bufferedImage = image.getBufferedImage();

        assertNull(bufferedImage);
    }

    @Test
    public void getBufferedImage() throws Exception {
        OpenImage image = new OpenImage(TARGET_CLASSES_PATH, NO_PASS_PNG);

        BufferedImage bufferedImage = image.getBufferedImage();

        assertNotNull(bufferedImage);
        assertEquals(588, bufferedImage.getWidth());
        assertEquals(850, bufferedImage.getHeight());
    }
}
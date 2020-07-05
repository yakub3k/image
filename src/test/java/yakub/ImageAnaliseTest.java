package yakub;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import yakub.image.ImageAnalise;
import yakub.image.OpenImage;

import java.awt.image.BufferedImage;

public class ImageAnaliseTest {


    @Test
    public void analise() throws Exception {
        OpenImage openImage = Mockito.mock(OpenImage.class);
        Mockito.when(openImage.isCorrect()).thenReturn(true);
        Mockito.when(openImage.isImage()).thenReturn(true);
        BufferedImage image = Mockito.mock(BufferedImage.class);
        Mockito.when(image.getRGB(Matchers.anyInt(), Matchers.anyInt())).thenReturn(1);
        Mockito.when(image.getWidth()).thenReturn(10);
        Mockito.when(image.getHeight()).thenReturn(10);
        Mockito.when(image.getType()).thenReturn(1);
        Mockito.when(openImage.getBufferedImage()).thenReturn(image);
        ImageAnalise imageAnalise = new ImageAnalise(openImage);

        imageAnalise.analise("test.png");

        Mockito.verify(openImage).isCorrect();
        Mockito.verify(openImage).isImage();
        Mockito.verify(openImage).getBufferedImage();
        Mockito.verify(image, Mockito.times(300)).getRGB(Matchers.anyInt(), Matchers.anyInt());
    }
}
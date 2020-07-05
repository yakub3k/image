package yakub.image;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageAnalise {

    private final OpenImage openImage;

    public ImageAnalise(OpenImage openImage) {
        this.openImage = openImage;
    }

    public void analise(String outputFile) throws Exception {
        if (openImage.isCorrect() && openImage.isImage()) {
            BufferedImage bufferedImage = openImage.getBufferedImage();
            Histogram histogram = new Histogram(bufferedImage);
            BufferedImage chart = histogram.histogram();
            ImageIO.write(chart, "png", new File(outputFile));
        }
    }


    public static void main(String[] args) throws Exception {
        OpenImage openImage = new OpenImage("target/classes/", "kubek.jpg");
        ImageAnalise imageAnalise = new ImageAnalise(openImage);
        imageAnalise.analise("output.png");
    }


}

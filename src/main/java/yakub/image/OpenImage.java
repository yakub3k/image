package yakub.image;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpenImage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenImage.class);

    private final Path directPath;

    public OpenImage(String path, String filename) {
        this.directPath = Path.of(path, filename);
    }

    public boolean isCorrect() {
        boolean exists = Files.exists(directPath);
        LOGGER.info("File '{}' exist:'{}'", directPath.toAbsolutePath(), exists);
        return exists;
    }

    public boolean isImage() throws IOException {
        return getContentType().contains("image");
    }

    public String getContentType() throws IOException {
        return Files.probeContentType(directPath);
    }

    public BufferedImage getBufferedImage() throws Exception {
        return ImageIO.read(directPath.toFile());
    }
}

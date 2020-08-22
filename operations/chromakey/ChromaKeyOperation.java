/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.chromakey;

import imageproc.model.AbstractOperation;
import imageproc.operations.OperationUtilities;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import imageproc.view.ImageWindow;

/**
 *
 * @author childm
 */
public class ChromaKeyOperation extends AbstractOperation {

    private ChromaKeyUI ui;

    public ChromaKeyOperation() {
        super("Selective replace", "Replaces all pixels of a certain colour in the orginal image with the corresponding ones from the other.");
    }

    @Override
    public JComponent settingsUI(ImageWindow view) {
        if (this.ui == null) {
            this.ui = new ChromaKeyUI(view.getFileChooser());
        }
        return this.ui;
    }

    @Override
    public BufferedImage execute(BufferedImage inputImage) {
        try {
            double sensitivity = this.ui.getSensitivity();
            BufferedImage otherImage = ImageIO.read(this.ui.getOtherImagePath());

            int targetRGB = this.ui.getTargetColor().getRGB();

            BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
            for (int x = 0; x < output.getWidth(); x++) {
                for (int y = 0; y < output.getHeight(); y++) {
                    int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
                    int otherRGB = OperationUtilities.getRGB(x, y, otherImage);
                    int outputRGB = OperationUtilities.chromaKey(inputRGB, otherRGB, targetRGB, sensitivity);
                    OperationUtilities.setRGB(x, y, outputRGB, output);
                }
            }
            return output;
        } catch (IOException ex) {
            ex.printStackTrace();
            return inputImage;
        }
    }

}

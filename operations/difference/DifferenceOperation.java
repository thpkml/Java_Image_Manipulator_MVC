/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.difference;

import imageproc.model.AbstractOperation;
import imageproc.operations.OperationUtilities;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author KamalT
 */
public class DifferenceOperation extends AbstractOperation {
    
    private DifferenceUI ui;
    
    public DifferenceOperation() {
        super("Difference", "Compares pixels in two images and leaves only the difference in their colours.");
    }

    @Override
    public JComponent settingsUI(ImageWindow view) {
        if (this.ui == null) {
            this.ui = new DifferenceUI(view.getFileChooser());
        }
        return this.ui;
    }

    @Override
    public BufferedImage execute(BufferedImage inputImage) {
        try {
            BufferedImage otherImage = ImageIO.read(this.ui.getOtherImagePath());

            BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
            for (int x = 0; x < output.getWidth(); x++) {
                for (int y = 0; y < output.getHeight(); y++) {
                    int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
                    int otherRGB = OperationUtilities.getRGB(x, y, otherImage);
                    int outputRGB = OperationUtilities.difference(inputRGB, otherRGB);
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

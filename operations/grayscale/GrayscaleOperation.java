/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.grayscale;

import imageproc.model.AbstractOperation;
import imageproc.operations.OperationUtilities;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author childm
 */
public class GrayscaleOperation extends AbstractOperation {

    public GrayscaleOperation() {
        super("Grayscale", "Changes image to gray scale");
    }

    @Override
    public JComponent settingsUI(ImageWindow view) {
        return new GrayscaleUI();
    }

    @Override
    public BufferedImage execute(BufferedImage inputImage) {
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
                int outputRGB = OperationUtilities.grayscale(inputRGB);
                OperationUtilities.setRGB(x, y, outputRGB, inputImage);
            }
        }
        return inputImage;
    }

}

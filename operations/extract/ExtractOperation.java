/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.extract;

import imageproc.model.AbstractOperation;
import imageproc.operations.ColourComponent;
import imageproc.operations.OperationUtilities;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author KamalT
 */
public class ExtractOperation extends AbstractOperation {
    
    private final ExtractUI ui = new ExtractUI();
    
    public ExtractOperation() {
        super("Extract", "Extracts only red, green or blue component of the image.");
    }

    @Override
    public JComponent settingsUI(ImageWindow view) {
        return this.ui;
    }

    @Override
    public BufferedImage execute(BufferedImage inputImage) {
        ColourComponent band = this.ui.getChosenColor();
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
                int outputRGB = OperationUtilities.extract(inputRGB, band);
                OperationUtilities.setRGB(x, y, outputRGB, inputImage);
            }
        }
        return inputImage;
    }
}

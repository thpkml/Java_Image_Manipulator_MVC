/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.tint;

import imageproc.model.AbstractOperation;
import imageproc.operations.ColourComponent;
import imageproc.operations.OperationUtilities;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author childm
 */
public class TintOperation extends AbstractOperation {

    private final TintUI ui = new TintUI();

    public TintOperation() {
        super("Tint", "Tints image towards red, green or blue.");
    }

    @Override
    public JComponent settingsUI(ImageWindow view) {
        return this.ui;
    }

    @Override
    public BufferedImage execute(BufferedImage inputImage) {
        ColourComponent band = this.ui.getChosenColor();
        double alpha = this.ui.getAlpha() / 100.0;
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
                int outputRGB = OperationUtilities.tint(inputRGB, alpha, band);
                OperationUtilities.setRGB(x, y, outputRGB, inputImage);
            }
        }
        return inputImage;
    }

}

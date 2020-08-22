/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.model;

import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author childm
 */
public abstract class AbstractOperation implements Operation {

    private final String name;
    private final String description;

    public AbstractOperation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public abstract JComponent settingsUI(ImageWindow view);

    @Override
    public abstract BufferedImage execute(BufferedImage inputImage);

}

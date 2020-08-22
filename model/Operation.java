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
public interface Operation {

    /** Returns the name of this operation. */
    String name();

    /** Returns the description of this operation. */
    String description();

    /** Returns a subclass of JComponent that will be used in the OperationUI dialog. */
    JComponent settingsUI(ImageWindow view);

    /** 
     * Executes the operation on the given image, returning either the same image 
     * object after processing or a new image object. 
     */
    BufferedImage execute(BufferedImage inputImage);

}

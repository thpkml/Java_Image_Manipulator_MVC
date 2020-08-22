/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.control;

import imageproc.model.Model;
import imageproc.model.Operation;
import imageproc.operations.OperationFactory;
import imageproc.view.OperationUI;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.SwingUtilities;

/**
 *
 * @author childm
 */
public class Controller {

    private final ImageWindow view;
    private final Model model;

    public Controller(OperationFactory factory) {
        this.view = new ImageWindow(this);
        this.model = new Model(this.view, factory);
        this.view.setVisible(true);
    }

    public Model getModel() {
        return this.model;
    }

    public ImageWindow getView() {
        return this.view;
    }

    public void doOpenImage() {
        File file = this.view.chooseImageFile();
        if (file != null) {
            this.model.loadImage(file);
        }
    }

    public void doRevertImage() {
        this.model.revert();
    }

    public void doOperation(String name) {
        Operation operation = this.model.getOperation(name);
        OperationUI ui = new OperationUI(this.view, this, operation);
        ui.setVisible(true);
    }

    public void setNewImage(BufferedImage image) {
        this.model.setImage(image);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Controller(new OperationFactory()));
    }

}

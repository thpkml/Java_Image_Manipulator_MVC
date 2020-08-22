/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.model;

import imageproc.operations.OperationFactory;
import imageproc.operations.OperationFactory.OpID;
import imageproc.view.ImageWindow;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;

/**
 *
 * @author childm
 */
public class Model {

    private final ImageWindow view;

    private BufferedImage image;
    private File loadedImage;

    private final Map<OpID, Operation> operations = new TreeMap<>();

    public Model(ImageWindow view, OperationFactory factory) {
        this.view = view;
        for (OpID identifier : OpID.values()) {
            this.operations.put(identifier, factory.createOperation(identifier));
            this.view.addMenuOperation(identifier.toString());
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.view.setImage(this.image);
    }

    public void loadImage(File file) {
        try {
            this.image = ImageIO.read(file);
            this.loadedImage = file;
            this.view.setImage(this.image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void revert() {
        if (this.loadedImage != null) {
            loadImage(this.loadedImage);
        }
    }

    public Operation getOperation(String name) {
        return this.operations.get(OpID.valueOf(name));
    }
}

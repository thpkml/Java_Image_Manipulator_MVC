/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author childm
 */
public class ImagePanel extends JComponent {

    private BufferedImage image;

    public void setImage(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

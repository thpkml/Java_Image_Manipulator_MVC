/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.view;

import imageproc.control.Controller;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author childm
 */
public class ImageWindow extends JFrame {

    private final JFileChooser chooser = new JFileChooser();
    private final ImagePanel imagePanel = new ImagePanel();

    private final JMenu opMenu = new JMenu("Operations");
    private final Controller controller;

    public ImageWindow(Controller controller) {
        this.controller = controller;
        this.chooser.setMultiSelectionEnabled(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(ev -> controller.doOpenImage());
        fileMenu.add(openItem);

        JMenuItem revertItem = new JMenuItem("Revert");
        revertItem.addActionListener(ev -> controller.doRevertImage());
        fileMenu.add(revertItem);

        menuBar.add(fileMenu);
        menuBar.add(opMenu);
        setJMenuBar(menuBar);

        add(this.imagePanel, BorderLayout.CENTER);
        pack();
    }

    public JFileChooser getFileChooser() {
        return this.chooser;
    }

    public File chooseImageFile() {
        if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return this.chooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public void setImage(BufferedImage image) {
        this.imagePanel.setImage(image);
        pack();
    }

    public void addMenuOperation(String identifier) {
        JMenuItem item = new JMenuItem(identifier);
        item.addActionListener(ev -> controller.doOperation(identifier));
        this.opMenu.add(item);
    }
}

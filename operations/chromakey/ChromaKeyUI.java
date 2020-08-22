/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.chromakey;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author childm
 */
public class ChromaKeyUI extends JPanel {

    private final JTextField otherImagePath = new JTextField(60);
    private final JButton fileChooserButton = new JButton("Open");
    private final JColorChooser colorChooser = new JColorChooser();
    private final JSlider alphaSlider = new JSlider(0, 100);

    private final JFileChooser chooser;
    private File file;

    public ChromaKeyUI(JFileChooser chooser) {
        super(new BorderLayout());

        this.chooser = chooser;

        JPanel pathPanel = new JPanel();
        pathPanel.add(otherImagePath);
        pathPanel.add(fileChooserButton);
        pathPanel.setBorder(BorderFactory.createTitledBorder("Image to blend"));

        add(pathPanel, BorderLayout.NORTH);
        add(colorChooser, BorderLayout.CENTER);
        add(alphaSlider, BorderLayout.SOUTH);

        otherImagePath.setEditable(false);

        fileChooserButton.addActionListener(ev -> showChooser());
    }

    private void showChooser() {
        if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.file = this.chooser.getSelectedFile();
            otherImagePath.setText(file.getPath());
        }
    }

    public File getOtherImagePath() {
        return this.file;
    }

    public double getSensitivity() {
        return this.alphaSlider.getValue() / 100.0;
    }

    public Color getTargetColor() {
        return colorChooser.getColor();
    }
}

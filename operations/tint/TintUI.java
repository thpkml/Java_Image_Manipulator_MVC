/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations.tint;

import imageproc.operations.ColourComponent;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

/**
 *
 * @author childm
 */
public class TintUI extends JPanel {

    private final JRadioButton rButton = new JRadioButton("Red");
    private final JRadioButton gButton = new JRadioButton("Green");
    private final JRadioButton bButton = new JRadioButton("Blue");
    private final JSlider alphaSlider = new JSlider(0, 100);

    private ColourComponent selectedColor = ColourComponent.RED;

    public TintUI() {
        super(new BorderLayout());

        JPanel radioPanel = new JPanel();
        radioPanel.add(rButton);
        radioPanel.add(gButton);
        radioPanel.add(bButton);

        // make radio buttons mutually exclusive
        ButtonGroup bg = new ButtonGroup();
        bg.add(rButton);
        bg.add(gButton);
        bg.add(bButton);

        rButton.setSelected(true);

        rButton.addActionListener((ev) -> colourChosen(ColourComponent.RED));
        gButton.addActionListener((ev) -> colourChosen(ColourComponent.GREEN));
        bButton.addActionListener((ev) -> colourChosen(ColourComponent.BLUE));

        add(radioPanel, BorderLayout.CENTER);
        add(alphaSlider, BorderLayout.SOUTH);
    }

    private void colourChosen(ColourComponent colour) {
        this.selectedColor = colour;
    }

    public ColourComponent getChosenColor() {
        return this.selectedColor;
    }

    public int getAlpha() {
        return this.alphaSlider.getValue();
    }
}

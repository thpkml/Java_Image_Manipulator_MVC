/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.view;

import imageproc.model.Operation;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import imageproc.control.Controller;
import java.awt.image.BufferedImage;

/**
 *
 * @author childm
 */
public class OperationUI extends JDialog {

    private final JButton applyButton = new JButton("Apply");
    private final JButton cancelButton = new JButton("Cancel");
    
    private final Controller controller;
    private final Operation operation;

    public OperationUI(ImageWindow frame, Controller controller, Operation operation) {
        super(frame, operation.name(), true);

        this.controller = controller;
        this.operation = operation;
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(this.applyButton);
        buttonPanel.add(this.cancelButton);

        add(operation.settingsUI(frame), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        this.applyButton.addActionListener(ev -> doApplyButton());
        this.cancelButton.addActionListener(ev -> setVisible(false));

        pack();
    }

    private void doApplyButton() {
        setVisible(false);
        BufferedImage input = this.controller.getModel().getImage();
        BufferedImage result = this.operation.execute(input);
        this.controller.setNewImage(result);
    }
}

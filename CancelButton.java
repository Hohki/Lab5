package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CancelButton extends CalculatorButton {
    public CancelButton(Situation situation, JPanel JPanel) {
        super("C", situation);
        JPanel.add(this);
    }

    public void transition() {
        situation.display.setText("0");
        situation.state = State.Input1;
        this.setColor(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CancelButton has been called...");
        transition();
    }
}

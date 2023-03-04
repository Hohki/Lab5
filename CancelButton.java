package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CancelButton extends CalculatorButton {
    public CancelButton(Situation situation, JPanel JPanel, ActionListener listener) {
        super("C", situation, listener);
        JPanel.add(this);
    }

    public void transition() {
        situation.display.setText("0");
        situation.state = State.Input1;
        this.setColor(Color.WHITE);
    }
}

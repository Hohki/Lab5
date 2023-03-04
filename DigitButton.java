package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DigitButton extends CalculatorButton {
    Situation situation;

    public DigitButton(String str, Situation situation, JPanel JPanel, ActionListener listener) {
        super(str, situation, listener);
        this.situation = situation;
        JPanel.add(this);
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input1, HasResult, Input2:
                if (situation.display.getText().equals("0")) {
                    situation.display.setText("" + this.getText());
                } else {
                    situation.display.setText("" +situation.display.getText() + this.getText());
                }
                break;
            case OpReady:
                situation.state = State.Input2;
                situation.display.setText("" + this.getText());
            default:
                break;
        }
    }
}

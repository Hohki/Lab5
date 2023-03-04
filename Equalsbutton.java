package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Equalsbutton extends CalculatorButton {
    public Equalsbutton(Situation situation, JPanel JPanel,  ActionListener listener) {
        super("=", situation, listener);
        JPanel.add(this);
    }


    @Override
    public void transition() {
        switch (situation.state) {
            case Input1, HasResult, OpReady:
                System.out.println("You are pressing the equals button");
                break;
            case Input2:
                situation.display.setText("" + situation.binaryOperator.intBinaryOperator().applyAsInt(situation.leftOperand, Integer.parseInt(situation.display.getText())));
                situation.state = State.HasResult;
            default:
                break;
        }
    }
}

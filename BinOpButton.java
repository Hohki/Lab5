package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator intBinaryOperator;

    public BinOpButton(String str, Situation situation, ActionListener listener, JPanel JPanel, IntBinaryOperator intBinaryOperator) {
        super(str, situation, listener);
        this.intBinaryOperator = intBinaryOperator;
        JPanel.add(this);
        System.out.println(this.intBinaryOperator);
    }

    public IntBinaryOperator intBinaryOperator() {
        return this.intBinaryOperator;
    }

    //?????????????
    public void transition() {
        switch (situation.state) {
            case Input1, HasResult:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOperator = this;
                situation.state = State.OpReady;
                break;
            case OpReady:
                situation.binaryOperator.setColor(Color.WHITE);
                situation.binaryOperator = this;
                this.setColor(Color.RED);
                situation.state = State.Input2;
            default:
                break;
        }
    }

}

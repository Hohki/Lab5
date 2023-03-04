package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator intBinaryOperator;

    public BinOpButton(String str, Situation situation, JPanel JPanel, IntBinaryOperator intBinaryOperator) {
        super(str, situation);
        this.intBinaryOperator = intBinaryOperator;
        JPanel.add(this);
    }

    public IntBinaryOperator intBinaryOperator() {
        return this.intBinaryOperator;
    }

    public void transition() {
        switch (situation.state) {
            case Input1, HasResult:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOperator = this;
                situation.state = State.OpReady;
                this.setColor(Color.RED);
                break;
            case OpReady:
                situation.binaryOperator.setColor(Color.WHITE);
                situation.binaryOperator = this;
                this.setColor(Color.RED);
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("BinOpButton has been called...");
        transition();
    }
}

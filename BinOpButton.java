package Lab5;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator intBinaryOperator;

    public BinOpButton(String str, Situation situation, ActionListener listener, IntBinaryOperator intBinaryOperator) {
        super(str, situation, listener);
        this.intBinaryOperator = intBinaryOperator;
    }

    //?????????????
    @Override
    public void transition(int x, int y) {
        if (situation.state == State.Input1 || situation.state == State.HasResult) {
            situation.leftOperand = x;
            situation.binaryOperator = this;
            this.setColor(Color.RED);
        } else if (situation.state == State.OpReady) {
            this.setColor(Color.WHITE);
            situation.binaryOperator = this;
        }
    }
}

package Lab5;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class Equalsbutton extends CalculatorButton {
    public Equalsbutton(Situation situation, JPanel JPanel) {
        super("=", situation);
        JPanel.add(this);
    }


    @Override
    public void transition() {
        switch (situation.state) {
            case Input1, HasResult, OpReady:
                break;
            case Input2:
                situation.display.setText("" + situation.binaryOperator.intBinaryOperator().applyAsInt(situation.leftOperand, Integer.parseInt(situation.display.getText())));
                situation.state = State.HasResult;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Equalsbutton has been called...");
        transition();
    }
}

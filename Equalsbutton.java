// Gabriel Axheim Gustafsson, Albin Kullberg, Khaled Chaaban
package Lab5;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Equalsbutton extends CalculatorButton {
	public Equalsbutton(Situation situation, JPanel JPanel) {
		super("=", situation);
		JPanel.add(this);
	}

	@Override
	public void transition() throws ArithmeticException {
		switch (situation.state) {
		case Input1, HasResult, OpReady:
			break;
		case Input2:
			try {
				situation.display.setText("" + situation.binaryOperator.intBinaryOperator()
						.applyAsInt(situation.leftOperand, Integer.parseInt(situation.display.getText())));
				situation.state = State.HasResult;
				situation.binaryOperator.setColor(Color.WHITE);

			} catch (Exception e) {
				System.out.println("Kan inte dela med 0!");
				situation.state = State.Input1;
				situation.binaryOperator.setColor(Color.WHITE);
			}
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

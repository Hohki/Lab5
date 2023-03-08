// Gabriel Axheim Gustafsson, Albin Kullberg, Khaled Chaaban
package Lab5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DigitButton extends CalculatorButton {
	private Situation situation;

	public DigitButton(String str, Situation situation, JPanel JPanel) {
		super(str, situation);
		this.situation = situation;
		JPanel.add(this);
	}

	@Override
	public void transition() {
		switch (this.situation.state) {
		case Input1, Input2:
			if (situation.display.getText().equals("0")) {
				situation.display.setText("" + this.getText());
			} else {
				situation.display.setText("" + situation.display.getText() + this.getText());
			}
			break;
		case HasResult:
			situation.state = State.Input1;
			situation.display.setText("" + this.getText());
			break;
		case OpReady:
			situation.state = State.Input2;
			situation.display.setText("" + this.getText());
			break;
		default:
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("DigiButton has been called...");
		transition();
	}
}

// Gabriel Axheim Gustafsson, Albin Kullberg, Khaled Chaaban
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
    	switch(situation.state) {
    		case Input1, HasResult:
    			situation.display.setText("0");
            	situation.state = State.Input1;
            	break;
    		case OpReady, Input2:
    			situation.display.setText("0");
            	situation.state = State.Input1;
            	situation.binaryOperator.setColor(Color.WHITE);
            	break;
            default:
            	break;
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CancelButton has been called...");
        transition();
    }
}

// Gabriel Axheim Gustafsson, Albin Kullberg, Khaled Chaaban
package Lab5;

import java.awt.*;
import java.util.function.IntBinaryOperator;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JFrame {
	private IntBinaryOperator intBinaryOperator;
	private Situation situation;

	public GUI() {
		JFrame calculator = new JFrame("Calculator");
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		JPanel canvas = new JPanel();
		canvas(canvas, c);

		JLabel display = new JLabel("0", SwingConstants.RIGHT);
		display(display, c);
		canvas.add(display, c);
		this.situation = new Situation(display);

		JPanel keypad = new JPanel(new GridLayout(4, 4));
		keypad(keypad, c);
		canvas.add(keypad, c);
		keys(keypad, situation);

		calculator.add(canvas);
		calculator.pack();
		calculator.setVisible(true);
	}

	private void canvas(JPanel canvas, GridBagConstraints c) {
		canvas.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
	}

	private void display(JLabel display, GridBagConstraints c) {
		display.setPreferredSize(new Dimension(400, 60));
		display.setHorizontalTextPosition(JLabel.RIGHT);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("Ariel", Font.BOLD, 25);
		display.setOpaque(true);
		display.setBackground(Color.WHITE);
		display.setFont(font);
		display.setBorder(border);
	}

	private void keypad(JPanel keypad, GridBagConstraints c) {
		keypad.setPreferredSize(new Dimension(400, 400));
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
		keypad.setBorder(border1);
		c.gridy = 1;
	}

	// Fattar inte hur det här fungerar men jag klagar inte :)
	private void keys(JPanel keypad, Situation situation) {
		new DigitButton("7", situation, keypad);
		new DigitButton("8", situation, keypad);
		new DigitButton("9", situation, keypad);
		new BinOpButton("/", situation, keypad, intBinaryOperator = (x, y) -> {
			return x / y;
		});

		new DigitButton("4", situation, keypad);
		new DigitButton("5", situation, keypad);
		new DigitButton("6", situation, keypad);
		new BinOpButton("*", situation, keypad, intBinaryOperator = (x, y) -> {
			return x * y;
		});

		new DigitButton("1", situation, keypad);
		new DigitButton("2", situation, keypad);
		new DigitButton("3", situation, keypad);
		new BinOpButton("-", situation, keypad, intBinaryOperator = (x, y) -> {
			return x - y;
		});

		new DigitButton("0", situation, keypad);
		new Equalsbutton(situation, keypad);
		new CancelButton(situation, keypad);
		new BinOpButton("+", situation, keypad, intBinaryOperator = (x, y) -> {
			return x + y;
		});

	}

}

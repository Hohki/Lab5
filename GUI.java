package Lab5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener {
	IntBinaryOperator intBinaryOperator;
	public GUI() {
		JFrame calculator = new JFrame("Calculator");
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		JPanel canvas = new JPanel();
		canvas(canvas, c);

		JLabel display = new JLabel("0", SwingConstants.RIGHT);
		display(display, c);
		canvas.add(display, c);
		Situation situation = new Situation(display);

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
		Font font = new Font("Ariel", Font.BOLD,25);
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
	
	private void keys(JPanel keypad, Situation situation) {
		new DigitButton("7", situation, keypad, this);
		new DigitButton("8", situation, keypad, this);
		new DigitButton("9", situation, keypad, this);
		new BinOpButton("/", situation, this, keypad, intBinaryOperator = (x,y) -> {
			return x/y ;
		});

		new DigitButton("4", situation, keypad, this);
		new DigitButton("5", situation, keypad, this);
		new DigitButton("6", situation, keypad, this);
		new BinOpButton("*", situation, this, keypad, intBinaryOperator = (x,y) -> {
			return x*y ;
		});

		new DigitButton("1", situation, keypad, this);
		new DigitButton("2", situation, keypad, this);
		new DigitButton("3", situation, keypad, this);
		new BinOpButton("-", situation, this, keypad, intBinaryOperator = (x,y) -> {
			return x-y ;
		});

		new DigitButton("0", situation, keypad, this);
		new Equalsbutton(situation, keypad, this);
		new CancelButton(situation, keypad, this);
		new BinOpButton("+", situation, this, keypad, intBinaryOperator = (x,y) -> {
			return x+y ;
		});


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("An action has been performed...");
	}
}

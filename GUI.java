package Lab5;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JFrame{
	
	public GUI() {
		JFrame calculator = new JFrame("Calculator");
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		JPanel canvas = new JPanel();
		canvas(canvas, c);
		
		JLabel display = new JLabel("0", SwingConstants.RIGHT);
		display(display, c);
		canvas.add(display, c);
		
		JPanel keypad = new JPanel(new GridLayout(4, 4));
		keypad(keypad, c);
		canvas.add(keypad, c);
		keys(keypad);
		
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
	
	private void keys(JPanel keypad) {
		Font font = new Font("Ariel", Font.BOLD,25);
		
		JButton sju = new JButton("7");
		sju.setBackground(Color.WHITE);
		sju.setFont(font);
		keypad.add(sju);
		
		JButton åtta = new JButton("8");
		åtta.setBackground(Color.WHITE);
		åtta.setFont(font);
		keypad.add(åtta);
		
		JButton nio = new JButton("9");
		nio.setBackground(Color.WHITE);
		nio.setFont(font);
		keypad.add(nio);
		
		JButton delat = new JButton("/");
		delat.setBackground(Color.WHITE);
		delat.setFont(font);
		keypad.add(delat);
		
		JButton fyra = new JButton("4");
		fyra.setBackground(Color.WHITE);
		fyra.setFont(font);
		keypad.add(fyra);
		
		JButton fem = new JButton("5");
		fem.setBackground(Color.WHITE);
		fem.setFont(font);
		keypad.add(fem);
		
		JButton sex = new JButton("6");
		sex.setBackground(Color.WHITE);
		sex.setFont(font);
		keypad.add(sex);
		
		JButton gånger = new JButton("*");
		gånger.setBackground(Color.WHITE);
		gånger.setFont(font);
		keypad.add(gånger);
		
		JButton ett = new JButton("1");
		ett.setBackground(Color.WHITE);
		ett.setFont(font);
		keypad.add(ett);
		
		JButton två = new JButton("2");
		två.setBackground(Color.WHITE);
		två.setFont(font);
		keypad.add(två);
		
		JButton tre = new JButton("3");
		tre.setBackground(Color.WHITE);
		tre.setFont(font);
		keypad.add(tre);
		
		JButton minus = new JButton("-");
		minus.setBackground(Color.WHITE);
		minus.setFont(font);
		keypad.add(minus);
		
		JButton noll = new JButton("0");
		noll.setBackground(Color.WHITE);
		noll.setFont(font);
		keypad.add(noll);
		
		JButton lika = new JButton("=");
		lika.setBackground(Color.WHITE);
		lika.setFont(font);
		keypad.add(lika);
		
		JButton reset = new JButton("C");
		reset.setBackground(Color.WHITE);
		reset.setFont(font);
		keypad.add(reset);
		
		JButton plus = new JButton("+");
		plus.setBackground(Color.WHITE);
		plus.setFont(font);
		keypad.add(plus);
	}
}

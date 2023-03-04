package Lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class CalculatorButton extends JButton{
    Situation situation;
    public CalculatorButton(String str, Situation situation, ActionListener listener) {
        super(str);
        this.situation = situation;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 400)); //Ändrar storleken på knappen
        this.setFont(new Font("Ariel", Font.BOLD,25)); //Ändrar typsnitt och storlek
        this.addActionListener(listener);
    }

    //Den abstrakta metoden som ska implementeras i varje knapp
    public abstract void transition();
    public void setColor(Color color) {this.setBackground(color);}
    public String toString() {return this.getText();}
}

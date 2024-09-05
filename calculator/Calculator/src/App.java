import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    String operator;

    // Custom class to create rounded buttons
    class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setFont(myFont);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);  // Rounded corners
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth(), getHeight(), 30, 30);  // Rounded corners
            g2.dispose();
        }
    }

    App() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new RoundButton("+");
        subButton = new RoundButton("-");
        mulButton = new RoundButton("*");
        divButton = new RoundButton("/");
        decButton = new RoundButton(".");
        equButton = new RoundButton("=");
        delButton = new RoundButton("Delete");
        clrButton = new RoundButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.WHITE);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new RoundButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground((new Color(173, 216, 230)));

        // Add number buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App calc = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // You can add logic for the calculator functions here
        for (int i = 0; i < 10; i++) {
            if(e.getSource()== numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }

        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                result = num1+num2;
                    break;
                case "-":
                result = num1-num2;
                    break;
                case "*":
                result = num1*num2;
                    break;
                case "/":
                result = num1/num2;
                    break;
                default:
                    throw new AssertionError();
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}

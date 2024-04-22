import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
    JFrame fram = new JFrame("prog");
    JButton butt = new JButton("Принять данные");
    JLabel lbl1 = new JLabel("Поле 1");
    JLabel lbl2 = new JLabel("Поле 2");
    JLabel lbl3 = new JLabel("Поле 3");
    JTextField fld1 = new JTextField("");
    JTextField fld2 = new JTextField("");
    JTextField fld3 = new JTextField("");
    String val = "  a=" + Ex.a + "\n" + "  b=" + Ex.b + "\n" + "  c=" + Ex.c;
    TextArea text = new TextArea(val, 4, 4);
    JButton butt1 = new JButton("Печать данных");
    public Main() {

        lbl1.setBounds(60, 40, 85, 30);
        fram.add(lbl1);
        fld1.setBounds(30, 80, 150, 30);
        fram.add(fld1);
        lbl2.setBounds(60, 120, 85, 30);
        fram.add(lbl2);
        fld2.setBounds(30, 160, 150, 30);
        fram.add(fld2);
        lbl3.setBounds(60, 200, 85, 30);
        fram.add(lbl3);
        fld3.setBounds(30, 240, 150, 30);
        fram.add(fld3);
        butt.setBounds(30, 290, 150, 30);
        fram.add(butt);
        butt1.setBounds(200, 200, 150, 30);
        fram.add(butt1);
        text.setBounds(200, 60, 200, 100);
        fram.add(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram.setSize(500, 500);
        fram.setLayout(null);
        fram.setVisible(true);

        butt.addActionListener((e) ->
        {
            onbuttclick();
        });
        butt1.addActionListener((e) ->
        {
            onbutt1click();
        });
    }

        private void onbuttclick ()
        {
            String str1 = fld1.getText(); // Получить ввод
            String str2 = fld2.getText();
            String str3 = fld3.getText();
            if (!str1.equals("")) {
                Ex.a = str1;
            }
            if (!str2.equals("")) {
            Ex.b = str2;
        }
            if (!str3.equals("")) {
            Ex.c = str3;
        }
            JOptionPane.showMessageDialog (this, "Данные приняты");
        }
    private void onbutt1click ()
    {
        text.setText ("  a=" + Ex.a + "\n" + "  b=" + Ex.b + "\n" + "  c=" + Ex.c);
    }

    public static void main(String args[])
    {
        new Main ();
    }

}

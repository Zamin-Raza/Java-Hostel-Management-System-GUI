import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class optionalAddGUI extends JFrame implements Serializable {
    JButton reservedadd, addnew , EXIT,BACK;



    Container c;


    optionalAddGUI() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = this.getContentPane();

        setVisible(true);

        setLayout(new FlowLayout());

        reservedadd = new JButton("ALREADY RESERVED");

        addnew = new JButton("NEW HOSTELITE");

        Font fontbt = new Font("TIMES NEW ROMAN",1,17);

        EXIT = new JButton("EXIT");
        BACK = new JButton("BACK");
        reservedadd.setBounds(85,60,220,120);
        addnew.setBounds(85,260,220,120);
        EXIT.setBounds(85,400,100,70);
        BACK.setBounds(220,400,100,70);
        c.setBackground(new Color(47, 76, 107));

        reservedadd.setBackground(new Color(255, 184, 0));
        addnew.setBackground(new Color(255, 183, 0));
        EXIT.setBackground(new Color(0, 0, 0));
        BACK.setBackground(new Color(0, 0, 0));

        addnew.setFont(fontbt);
        reservedadd.setFont(fontbt);
        BACK.setFont(fontbt);
        EXIT.setFont(fontbt);





        setLayout(null);

        MyActionlistener9 opt = new MyActionlistener9();


        c.add(reservedadd);
        c.add(addnew);
        c.add(EXIT);
        c.add(BACK);

        reservedadd.addActionListener(opt);
        addnew.addActionListener(opt);
        EXIT.addActionListener(opt);
        BACK.addActionListener(opt);



    }


    public class MyActionlistener9 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("ALREADY RESERVED")) {
                    new alreadyGUI();
                    dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("NEW HOSTELITE")) {
                new Addwindow();
                dispose();

            }
            else if (e.getActionCommand().equalsIgnoreCase("EXIT")) {
                System.exit(1);


            }
            else if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                new MainWindow();
                dispose();

            }
        }
    }
}
//


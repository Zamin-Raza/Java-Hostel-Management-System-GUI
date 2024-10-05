import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newDisplaytable extends JFrame {
    //    JTable t;
    JTextArea t1;
    JScrollPane scroll;
    JPanel p1;

    JButton back, exit;
    Container c;
    int[] arr = new int[2];

    newDisplaytable(ArrayList<hostelite> x) {

        c = this.getContentPane();


        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        back = new JButton("BACK");
        exit = new JButton("EXIT");
        c.setLayout(null);


//        t=new JTable(2,5);

//        p1 = new JPanel();

//        add(p1);

        t1 = new JTextArea(50, 50);
        scroll = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll.setBounds(60, 90, 500, 500);
        back.setBounds(70, 500, 70, 30);
        exit.setBounds(190, 500, 70, 30);

        back.setBackground(new Color(0, 0, 0));
        exit.setBackground(new Color(0, 0, 0));
        back.setForeground(new Color(255, 255, 255));
        exit.setForeground(new Color(255, 255, 255));

        c.add(back);
        c.add(exit);
//        c.add(t1);
        c.add(scroll);


        t1.setText("STUDENT DATA");
        t1.setFont(new Font("TIMES NEW ROMAN", 1, 12));
        t1.setEditable(false);

        for (hostelite check :x) {


           String str = "\nNAME : " + check.getName() + "\nADDRESS " + check.getAddress() + "\n MOBILE: " + check.getMobile() +
                   "\nROOM NUMBER " + check.room.getNumber();


            t1.setText(t1.getText() + "\n" + str);
        }
        MyActionlistenerdis fg = new MyActionlistenerdis();
        back.addActionListener(fg);
        exit.addActionListener(fg);
    }

    public class MyActionlistenerdis implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new Searchstdwindow();
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(1);


            }
        }
    }
}


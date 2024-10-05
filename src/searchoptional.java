import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchoptional extends JFrame {
    JButton reservedadd, addnew, EXIT, BACK;

    JLabel roomno;

    JTextField t;


    Container c;


    searchoptional() {
        setSize(650, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = this.getContentPane();

        setVisible(true);

        setLayout(new FlowLayout());

        reservedadd = new JButton("ROOM DETAIL");

        addnew = new JButton("SEARCH STUDENTS");

        roomno = new JLabel("ROOM NO ");

        t = new JTextField();

        Font fontbt = new Font("TIMES NEW ROMAN", 1, 17);

        EXIT = new JButton("EXIT");
        BACK = new JButton("BACK");
        reservedadd.setBounds(20, 60, 200, 40);
        addnew.setBounds(245, 60, 200, 40);
        roomno.setBounds(100,140,140,30);
        t.setBounds(100, 200, 200, 30);
        EXIT.setBounds(70, 400, 100, 40);
        BACK.setBounds(250, 400, 100, 40);
        c.setBackground(new Color(47, 76, 107));

        reservedadd.setBackground(new Color(255, 184, 0));
        addnew.setBackground(new Color(255, 183, 0));
        EXIT.setBackground(new Color(0, 0, 0));
        BACK.setBackground(new Color(0, 0, 0));

        EXIT.setForeground(new Color(255,255,255));
        BACK.setForeground(new Color(255,255,255));
        roomno.setForeground(new Color(255,255,255));


        addnew.setFont(fontbt);
        reservedadd.setFont(fontbt);
        roomno.setFont(fontbt);
        BACK.setFont(fontbt);
        EXIT.setFont(fontbt);


        setLayout(null);

        MyActionlisteneropt opt = new MyActionlisteneropt();


        c.add(reservedadd);
        c.add(addnew);
        c.add(roomno);
        c.add(t);
        c.add(EXIT);
        c.add(BACK);

        reservedadd.addActionListener(opt);
        addnew.addActionListener(opt);
        EXIT.addActionListener(opt);
        BACK.addActionListener(opt);


    }


    public class MyActionlisteneropt implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("ROOM DETAIL")) {
                if (!(t.getText().isEmpty())){
                    Room h = FileOperations.specificroom(Integer.parseInt(t.getText()));
                    new Roomdetail(h);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame() , "ENTER ROOM NUMBER");
                }

            } else if (e.getActionCommand().equalsIgnoreCase("SEARCH STUDENTS")) {
                new Searchstdwindow();
                dispose();

            } else if (e.getActionCommand().equalsIgnoreCase("EXIT")) {
                System.exit(1);


            } else if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                new MainWindow();
                dispose();

            }
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Updatewindow extends JFrame {
    JLabel title, name,address,mob,byid;
    JTextField fname,fadress,fmob,fid;
    JButton submit, exit, back, paid;
    JPanel p1, p2, p3;

    Updatewindow() {
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
//        setResizable(false);
//        setLayout(new GridLayout(2,2));
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(4, 2));
        p3.setLayout(new FlowLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        p2.setSize(30, 40);
        p2.setBackground(new Color(27, 39, 73));

        Font f = new Font("TIMES NEW ROMAN",1,18);

        byid = new JLabel("Enter ID");


        fid = new JTextField(20);
        name = new JLabel("Enter Name");
        name.setSize(15, 20);
        address = new JLabel("Enter Adress ");
        fname = new JTextField(20);
        fadress = new JTextField(20);
        mob = new JLabel("Enter Mobile Number");
        fmob = new JTextField(20);
        title = new JLabel("CAPITAL VIEW BOYS HOSTEL");
        title.setFont(f);
        title.setBackground(new Color(17, 32, 47));
        p1.add(title);

        title.setForeground(new Color(255, 0, 0));
        ArrayList<JTextField> tf = new ArrayList<JTextField>();
        ArrayList<JLabel> JB = new ArrayList<JLabel>();
        p3.setBackground(new Color(26, 138, 33));

        JB.add(byid);
        tf.add(fid);
        JB.add(name);
        tf.add(fname);
        JB.add(address);
        tf.add(fadress);
        JB.add(mob);
        tf.add(fmob);

        for (int i = 0 ; i<tf.size() ; i++){
            p2.add(JB.get(i));
            JB.get(i).setFont(f);
            JB.get(i).setForeground(new Color(255,255,255));
            p2.add(tf.get(i));
            tf.get(i).setFont(f);
            tf.get(i).setForeground(new Color(0, 0, 0));
        }






        submit = new JButton("Submit");
        exit = new JButton("Exit");
        back = new JButton("Back");
        p3.add(submit);
        p3.add(exit);
        p3.add(back);

        MyActionlistener5 up = new MyActionlistener5();
        submit.addActionListener(up);
        back.addActionListener(up);
        exit.addActionListener(up);

    }
    public class MyActionlistener5 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Submit")){
                if(fid.getText().isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"Eneter ID");
                }
                else{
                    if (!(fname.getText().isEmpty())){
                       if(!(FileOperations.searchbyID(fid.getText())==null)){
                           System.out.println("nahi milla");
                           FileOperations.updatename(fid.getText(),fname.getText());
                           JOptionPane.showMessageDialog(new JFrame(),"UPDATED SUCCESSFULLY");
                       }
                       else{
                           JOptionPane.showMessageDialog(new JFrame(),"RECORD NOT FOUNDED");
                       }

                    }
                    if (!(fmob.getText().isEmpty())){
                        FileOperations.updatemob(fid.getText(),fmob.getText());
                    }
                    if (!(fadress.getText().isEmpty())){
                        FileOperations.updateadress(fid.getText(),fadress.getText());
                    }

                }

            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(1);

            } else if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new MainWindow();

            }

        }
    }


}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deletewindow extends JFrame{
    JLabel byid;
    JTextField fid;
    JButton submit, exit, back,paid;
    JPanel p1, p2, p3;
    Deletewindow(){
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
//        setResizable(false);
//        setLayout(new GridLayout(2,2));
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(null);
        p3.setLayout(new FlowLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        p2.setSize(30, 40);
        p2.setBackground(new Color(112, 117, 192));

        Font f1 = new Font("Times New Roman",1,18);

        p1.setBackground(new Color(118, 246, 109));








        byid = new JLabel("Enter ID");



        fid = new JTextField(20);
        byid.setFont(f1);
        fid.setFont(f1);

        byid.setBounds(160,100,430,60);
        fid.setBounds(160,150,400,60);

        p2.add(byid);
        p2.add(fid);
        MyActionlistener4 del = new MyActionlistener4();

        submit = new JButton("Submit");
        exit = new JButton("Exit");
        back = new JButton("Back");
        p3.add(submit);
        p3.add(exit);
        p3.add(back);
        submit.addActionListener(del);
        exit.addActionListener(del);
        back.addActionListener(del);
    }
    public class MyActionlistener4 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Submit")){
                if (!(fid.getText()==null)) {
                    hostelite hos = FileOperations.searchbyID(fid.getText());
                    FileOperations.delete(fid.getText());

                    FileOperations.delcurrent(hos.getRoom().number);
                    JOptionPane.showMessageDialog(new JFrame(), "DELETED SUCCESSFULLY");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),"FILL THE FIELDS");
                }
            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(1);

            } else if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new MainWindow();

            }

            }
        }

}




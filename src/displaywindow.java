import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class displaywindow extends JFrame implements Serializable {
JLabel[] labels = new JLabel[12];
JLabel[] labels2 = new JLabel[12];

JLabel admdate,fdate;

JLabel title;

JPanel p1,p2,p3;

JButton Back,Exit;


displaywindow(hostelite x) {
    try {
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
//        setResizable(false);
//        setLayout(new GridLayout(2,2));
        setLayout(new BorderLayout());

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        title = new JLabel("CAPITAL VIEW BOYS HOSTEL");
        title.setFont(new Font("ARIAL",1,20));
        p1.add(title);

        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(8, 2));
        p3.setLayout(new FlowLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        p2.setSize(30, 40);
        p2.setBackground(new Color(255, 111, 111));


                labels2[1] = new JLabel(x.getName());
                labels2[2] = new JLabel(x.getAddress());
                labels2[3] = new JLabel(x.getId());
                labels2[4] = new JLabel(x.getMobile());
                labels2[5] = new JLabel(Integer.toString(x.getRoom().getNumber()));
                labels2[6] = new JLabel(Integer.toString(x.getRoom().getSeater()) + " Seater");
                labels2[7] = new JLabel(x.getInstitue());


        labels[0] = new JLabel(" ISLAMABAD");
        labels[1] = new JLabel("NAME OF HOSTELITE");
        labels[2] = new JLabel("ADDRESS OF HOSTELITE");
        labels[3] = new JLabel("ID OF HOSTELITE");
        labels[4] = new JLabel("MOBILE NUMBER OF HOSTELITE");
        labels[5] = new JLabel("ROOM NUMBER OF HOSTELITE");
        labels[6] = new JLabel("ROOM TYPE OF HOSTELITE");
        labels[7] = new JLabel("INSTITUTE OF HOSTELITE");


        admdate = new JLabel("DATE OF ADMSSION");
        fdate = new JLabel(x.getDateofadmission().date + " - " + x.getDateofadmission().month+" - "+" 2023");



        Back = new JButton("Back");
        Exit = new JButton("Exit");

        MyActionlistener6 dis = new MyActionlistener6();
        Back.addActionListener(dis);
        Exit.addActionListener(dis);



        p1.add(labels[0]);

        for (int i = 1; i < labels.length; i++) {
            if (labels[i] != null && labels2[i] != null) {
                p2.add(labels[i]);
                p2.add(labels2[i]);
                labels[i].setFont(new Font("ARIAL",1,16));
                labels2[i].setFont(new Font("ARIAL",1,16));
            }
        }
        p2.add(admdate);
        p2.add(fdate);
        admdate.setFont(new Font("ARIAL",1,16));
        fdate.setFont(new Font("ARIAL",1,16));
        p3.add(Back);
        p3.add(Exit);
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(new Frame(), "Record not founded");
    }
}
    public class MyActionlistener6 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new Addwindow();
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(1);

            }
        }
    }
}


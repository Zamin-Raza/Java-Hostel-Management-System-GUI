import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.io.Serializable;

public class Billwindow extends JFrame implements Serializable {
    JLabel byid,payment , fine , concession;
    JTextField fid,fpayment , ffine , fconcession;
    JButton submit, exit, back,paid;
    JPanel p1, p2, p3;

    Billwindow() {
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
        p2.setBackground(new Color(24, 145, 222));

        byid = new JLabel("Enter ID");
        payment = new JLabel("Enter Payment recieved");

        Font f1 = new Font("TIMES NEW ROMAN",1,18);


        fid = new JTextField(20);
        fpayment = new JTextField(20);
        fine = new JLabel("FINE");
        ffine = new JTextField(20);

        concession = new JLabel("CONCESSION");
        fconcession = new JTextField(20);


        p2.add(byid);
        p2.add(fid);
        p2.add(payment);
        p2.add(fpayment);
        p2.add(fine);
        p2.add(ffine);
        p2.add(concession);
        p2.add(fconcession);




        byid.setBounds(35,50,190,70);
        fid.setBounds(300,50,230,40);
        payment.setBounds(35,120,190,70);
        fpayment.setBounds(300,120,230,40);
        fine.setBounds(35,200,180,70);
        ffine.setBounds(300,200,230,40);
        concession.setBounds(35,270,170,70);
        fconcession.setBounds(300,270,230,40);

        byid.setForeground(new Color(255,255,255));
        payment.setForeground(new Color(255,255,255));
        concession.setForeground(new Color(255,255,255));
        fine.setForeground(new Color(255,255,255));
//        fpayment.setForeground(new Color(255,255,255));
//        fid.setForeground(new Color(255,255,255));

        byid.setFont(f1);
        fid.setFont(f1);
        payment.setFont(f1);
        fpayment.setFont(f1);
        ffine.setFont(f1);
        fconcession.setFont(f1);
        concession.setFont(f1);
        fconcession.setFont(f1);
        fine.setFont(f1);


        submit = new JButton("Submit");
        exit = new JButton("Exit");
        back = new JButton("Back");
        paid = new JButton("Paid");

MyActionlistener3 as = new MyActionlistener3();
    submit.addActionListener(as);
    exit.addActionListener(as);
    back.addActionListener(as);
    paid.addActionListener(as);
        p3.add(submit);
        p3.add(exit);
        p3.add(back);
        p3.add(paid);

    }


    public class MyActionlistener3 implements ActionListener {
        //

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new MainWindow();
                dispose();

            } else if (e.getActionCommand().equalsIgnoreCase("Submit")) {
                if (!(fid.getText().isEmpty())) {
                    double x;
//
                    if (!(ffine.getText().isEmpty())){
                        FileOperations.updatefine(fid.getText(),ffine.getText());
//                        System.out.println("fine para gya");
                       System.out.println(FileOperations.searchbyID(fid.getText()).getBill().getFine());
                        System.out.println(FileOperations.searchbyID(fid.getText()).totalrent());

                    }
                    if (!(fconcession.getText().isEmpty())){
                        FileOperations.updateconcession(fid.getText(),fconcession.getText());
                    }

                    hostelite h = FileOperations.searchbyID(fid.getText());
                    if (!(h==null)) {
                        x = h.totalrent();
                        System.out.println("TOTAL RENT IS "+x);
                        int dues =0;
                        if (h.getRoom().getSeater() == 2){
                            dues+=2000;
                        }
                        JOptionPane.showMessageDialog(new Frame(), "NAME: "+h.getName()+"\nRoom NUMBER: "+h.getRoom().getNumber()+
                              "\nFINE "+ h.getBill().getFine() +"\n CONCESSION   " + h.getBill().getConcession()+ "\nTOTAL RENT " + x);
                    } else {
                        JOptionPane.showMessageDialog(new Frame(), "RECORD NOT FOUNDED");
                    }
                }

            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(0);
            }

            else if(e.getActionCommand().equalsIgnoreCase("Paid")) {
                if (fid.getText().isEmpty() || fpayment.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "FILL THE FIELDS");
                } else {
                FileOperations.updatebill(fid.getText() , Integer.parseInt(fpayment.getText()));
                JOptionPane.showMessageDialog(new JFrame() ,"Paid successfully");
                }
            }
        }
    }

}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Login extends JFrame {
    JLabel title, id, password;
    JTextField fid;
    JPasswordField fpasswrod;
    JButton login, Exit;


    JLabel full;

    Container c;
//    ImageIcon img = new ImageIcon(getClass().getResource("CUI.jpg"));

    ImageIcon background = new ImageIcon("pic1.png");
    Image img = background.getImage();






    Login() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



        setLayout(null);






        setTitle("CBH");
        c = this.getContentPane();

        title = new JLabel("CAPITAL VIEW BOYS HOSTEL");
        id = new JLabel("ADMIN ID");
        password = new JLabel("PASSWORD");
        fid = new JTextField();
        fpasswrod = new JPasswordField();
        full = new JLabel(background);

        full.setSize(500,500);






        Font f = new Font("AGENCY FB", 1, 22);
        Font f2 = new Font("ARIAL",1,16);
        title.setFont(f);
        id.setFont(f);
//        fid.setFont(f);
        fid.setFont(f2);
        password.setFont(f);
//        fpasswrod.setFont(f);


        login = new JButton("LOGIN");
        Exit = new JButton("EXIT");


        c.setBackground(new Color(238, 181, 59));

        title.setBounds(90, 10, 300, 40);
        id.setBounds(35, 100, 120, 30);
        fid.setBounds(135, 100, 200, 30);
        password.setBounds(35, 150, 120, 30);
        fpasswrod.setBounds(135, 150, 200, 30);
        login.setBounds(57, 220, 95, 30);
        Exit.setBounds(190, 220, 95, 30);

        title.setBackground(new Color(225, 0, 0));
        id.setBackground(new Color(0, 0, 0));
        fid.setBackground(new Color(255, 255, 255));
        password.setBackground(new Color(255, 0, 0));
        fpasswrod.setBackground(new Color(255, 255, 255));

        MyActionlistener0 acc = new MyActionlistener0();




        c.add(title);
        c.add(id);
        c.add(password);
        c.add(fid);
        c.add(fpasswrod);
        c.add(login);
        c.add(Exit);

        login.addActionListener(acc);
        Exit.addActionListener(acc);
        c.add(full);

        setVisible(true);


    }

    public class MyActionlistener0 implements ActionListener {
        //

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("LOGIN")) {
                if (fid.getText().equalsIgnoreCase("ZAMIN") && fpasswrod.getText().equalsIgnoreCase("12345")) {
                    new MainWindow();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame() , "INVALID ID OR PASSWORD");
                }
            } else if (e.getActionCommand().equalsIgnoreCase("EXIT")) {
                System.exit(1);
            }
        }
    }
}

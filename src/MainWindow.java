import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {
        JButton addbtn,delbtn,searchbtn,billbtn,updatebtn,reserved,exit;

//        ImageIcon img;

    JLabel pic;


        JLabel title,dev;
        JTextField t,t2;
        JPanel p1,p2,p3;
//        ImageIcon img;

        MainWindow() {
            setSize(900, 700);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

//            setResizable(false);

//        setResizable(false);
//        setLayout(new GridLayout(2,2));
            setLayout(new BorderLayout());
            p1 = new JPanel();
            p2 = new JPanel();
            p3 = new JPanel();
            p1.setLayout(new FlowLayout());
            p2.setLayout(null);
            p3.setLayout(new FlowLayout());

            pic = new JLabel();

//            Image im = Toolkit.getDefaultToolkit().createImage("pic1.png");


//           ImageIcon img = new ImageIcon("pic1.png");
//           pic.setIcon(img);
//           pic.setBounds(620,30,300,200);
//
//           p2.add(pic);


            p2.setBackground(new Color(234, 185, 71));













            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            add(p3, BorderLayout.SOUTH);



            title =new JLabel("CAPITAL VIEW BOYS HOSTEL");
            addbtn = new JButton("ADD STUDENT RECORD");
            delbtn = new JButton("DELETE STUDENT RECORD");
            searchbtn = new JButton("SEARCH STUDENT RECORD");
            billbtn = new JButton("BILL OF STUDENT");
            updatebtn = new JButton("UPDATE STUDENT");
            reserved = new JButton("RESERVE A ROOM");
            exit = new JButton("EXIT");

            addbtn.setBackground(new Color(25, 14, 70));
            delbtn.setBackground(new Color(25,14,70));
            searchbtn.setBackground(new Color(25, 14, 70));
            billbtn.setBackground(new Color(25,14,70));
            updatebtn.setBackground(new Color(25, 14, 70));
            reserved.setBackground(new Color(25,14,70));
            dev = new JLabel("Developed by Zamin Raza");

            final Font FONT = new Font("Times New Roman",Font.BOLD,30);
            title.setFont(FONT);
            addbtn.setForeground(new Color(255, 255, 255));
            addbtn.setFont(FONT);
            delbtn.setForeground(new Color(255, 255, 255,232));
            delbtn.setFont(FONT);
            billbtn.setForeground(new Color(255, 255, 255));
            billbtn.setFont(FONT);
            searchbtn.setForeground(new Color(255, 255, 255,232));
            searchbtn.setFont(FONT);
            updatebtn.setFont(FONT);
            updatebtn.setForeground(new Color(255,255,255));
            reserved.setFont(FONT);
            reserved.setForeground(new Color(255,255,255));

            p2.setSize(500,330);




            addbtn.setBounds(200,35,450,60);
            delbtn.setBounds(200,115,450,60);
            searchbtn.setBounds(200,195,450,60);
            billbtn.setBounds(200,275,450,60);
            updatebtn.setBounds(200,355,450,60);
            reserved.setBounds(200,435,450,60);
            exit.setBounds(360,540,100,40);


            p1.add(title);
            p2.add(addbtn);
            p2.add(searchbtn);
            p2.add(delbtn);
            p2.add(billbtn);
            p2.add(updatebtn);
            p2.add(reserved);
            p2.add(exit);
            exit.setFont(new Font("TIMES NEW ROMAN",1,15));
            exit.setForeground(new Color(255,255,255));
            exit.setBackground(new Color(255, 0, 0));

            p3.add(dev);
            p2.add(reserved);
            title.setForeground(new Color(255, 255, 255));
            p1.setBackground(new Color(51, 150, 56));
            p3.setBackground(new Color(0, 250, 250));
            dev.setFont(new Font("ARIAL",Font.ITALIC , 16));


            MyActionlistener ae = new MyActionlistener();
            addbtn.addActionListener(ae);
            delbtn.addActionListener(ae);
            searchbtn.addActionListener(ae);
            billbtn.addActionListener(ae);
            updatebtn.addActionListener(ae);
            reserved.addActionListener(ae);
            exit.addActionListener(ae);
        }

    public class MyActionlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("ADD STUDENT RECORD")) {
//                new  Addwindow();
                new optionalAddGUI();
                dispose();
            }

             else if (e.getActionCommand().equalsIgnoreCase("DELETE STUDENT RECORD")) {
                new Deletewindow();
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("SEARCH STUDENT RECORD")) {
//                new Searchstdwindow();
                new searchoptional();
                dispose();

            } else if (e.getActionCommand().equalsIgnoreCase("UPDATE STUDENT")) {
                new Updatewindow();
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("BILL OF STUDENT")) {
                new Billwindow();
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("RESERVE A ROOM"))
            {
                new ReservedGUI();
                dispose();
            }
             else if (e.getActionCommand().equalsIgnoreCase("EXIT"));{
                 dispose();
            }



        }
    }


}



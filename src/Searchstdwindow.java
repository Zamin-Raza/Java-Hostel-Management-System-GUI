import com.sun.jdi.ArrayReference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Searchstdwindow extends JFrame implements Serializable {
    JCheckBox byname , byuni,byid,byroomno,byunpaid,bypaid;
    JLabel name,uni,id,roomno,unpaid,paid;

    JTextField fname,fid,froom,funi,funpaid,fpaid;

    JButton Submit,Exit,Back;
    JPanel p1,p2,p3;
            Searchstdwindow(){
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
                p2.setLayout(new GridLayout(9,1));
                p3.setLayout(new FlowLayout());
                add(p1, BorderLayout.NORTH);
                add(p2, BorderLayout.CENTER);
                add(p3, BorderLayout.SOUTH);
                p2.setSize(30, 40);
                p2.setBackground(new Color(255, 187, 0));

                byname = new JCheckBox("SEARCH BY NAME");
                byid = new JCheckBox("SEARCH BY ID");
//                byroomseat = new JCheckBox("SEARCH BY ROOMSEAT");
                byuni = new JCheckBox("SEARCH BY ISTITUTE");
                byroomno = new JCheckBox("SEARCH BY ROOM NUMBER");
//                bypaid = new JCheckBox("SEARCH FOR PAID HOSTELITES");
//                byuni = new JCheckBox("SEARCH FOR PAID HOSTELITES");
//                bybill = new JCheckBox(" ");

                Font f = new Font("TIMES NEW ROMAN",1,20);



                ButtonGroup c1 = new ButtonGroup();
                c1.add(byid);
                c1.add(byroomno);
                c1.add(byname);
                c1.add(byuni);
//                c1.add(bypaid);
//                c1.add(byunpaid);

                byid.setBackground(new Color(255, 184, 0));
                byroomno.setBackground(new Color(255, 180, 0));
                byuni.setBackground(new Color(255, 184, 0));
                byname.setBackground(new Color(255, 186, 0));
//                bypaid.setBackground(new Color(255, 184, 0));
//                byunpaid.setBackground(new Color(255, 186, 0));


                byid.setForeground(new Color(0, 0, 0));
                byuni.setForeground(new Color(0, 0, 0));
                byname.setForeground(new Color(0, 0, 0));
                byroomno.setForeground(new Color(0, 0, 0));
//                bypaid.setForeground(new Color(0, 0, 0));
//                byunpaid.setForeground(new Color(0, 0, 0));


//                c1.add(byroomseat);
//                c1.add(byuni);
//                c1.add(bybill);
                ArrayList<JCheckBox> ar1 = new ArrayList<>(4);
                ar1.add(byname);
                ar1.add(byroomno);
                ar1.add(byuni);
//                ar1.add(byroomseat);
                ar1.add(byid);
//                ar1.add(bypaid);
//                ar1.add(byunpaid);
//                ar1.add(bybill);
                MyActionlistener2 m2 = new MyActionlistener2();
                for (JCheckBox s: ar1){
                    p2.add(s);
                    s.addActionListener(m2);
                }
                name = new JLabel("ENTER NAME");
                roomno = new JLabel("ENETR ROOM NO");
//                roomseat = new JLabel("ENTER SEATER");
                uni = new JLabel("ENTER UNIVERSITY/INSTITUTE");
                id = new JLabel("ENTER ID");
                fname  = new JTextField(20);
                froom  = new JTextField(20);
                fid    = new JTextField(20);
//                fseat  = new JTextField(20);
                funi  = new JTextField(20);

                ArrayList<JLabel> ar2 = new ArrayList<>(4);
                ar2.add(name);
                ar2.add(id);
                ar2.add(roomno);
                ar2.add(uni);
//                ar2.add(roomseat);
                ArrayList<JTextField> ar3 = new ArrayList<>(5);
                ar3.add(fname);
                ar3.add(fid);
//                ar3.add(fseat);
                ar3.add(froom);
                ar3.add(funi);


                for (int i = 0 ; i<ar2.size() ; i++){
                    p2.add(ar2.get(i));
                    p2.add(ar3.get(i));
                    ar3.get(i).setEnabled(false);
                    ar2.get(i).setFont(f);
                    ar2.get(i).setForeground(new Color(0, 0, 0));
                    ar3.get(i).setFont(f);
                }

                Submit = new JButton("Search");
                Exit = new JButton("Exit");
                Back = new JButton("Back");
                MyActionlistener ma = new MyActionlistener();
                Submit.addActionListener(ma);
                Exit.addActionListener(ma);
                Back.addActionListener(ma);

                Submit.setBounds(new Rectangle(14,20));

                p3.add(Submit);
                p3.add(Exit);
                p3.add(Back);
            }
    public class MyActionlistener implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Back")){
                new MainWindow();
            }
            else if (e.getActionCommand().equalsIgnoreCase("Exit")){
                System.exit(1);
            }
            else if (e.getActionCommand().equalsIgnoreCase("Search")){
                if (byname.isSelected()){
                    if (fname.getText().isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(),"Enter name to be searched");

                    }
                    else{

                        new displaywindow(FileOperations.searchbyname(fname.getText()));
                        dispose();
                    }
                }
                else if (byroomno.isSelected()){
                    if (froom.getText().isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(),"Enter room no to be searched");
                    }
                    else{
//                        new newDisplaytable(froom.getText(),2);
//                        dispose();

                        ArrayList<hostelite> allsameroom = new ArrayList<hostelite>();
                        allsameroom= FileOperations.allsameuni(funi.getText());
                        new newDisplaytable(allsameroom);
                        dispose();
//                        for (hostelite s : allsameroom){
//                            System.out.println(s.getName());
//                        }
//
//
////                        System.out.println("Searched");
                    }
                }
                else if (byuni.isSelected()){
                    if (funi.getText().isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(),"Enter institute to be searched");
                    }
                    else{


                       ArrayList<hostelite> allsame = new ArrayList<hostelite>();
                        allsame= FileOperations.allsameuni(funi.getText());

                        new newDisplaytable(allsame);
//                       for (hostelite s : allsame){
//                           System.out.println(s.getName());
//                       }
//                        System.out.println("Searched");
                    }
                }
                else if (byid.isSelected()){
                    if (fid.getText().isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(),"Enter Id to be searched");
                    }
                    else{
                        System.out.println(fid.getText());

                        new displaywindow(FileOperations.searchbyID(fid.getText()));
                        System.out.println("Searched");
                    }
                }

            }
        }

        }
    public class MyActionlistener2 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            if (byname.isSelected()) {
                fname.setEnabled(true);
                funi.setEnabled(false);
                fid.setEnabled(false);
                froom.setEnabled(false);

                fname.setBackground(new Color(241, 79, 79));
                fname.setForeground(new Color(255,255,255));
            } else if (byid.isSelected()) {
                fname.setEnabled(false);
                funi.setEnabled(false);
                fid.setEnabled(true);
                froom.setEnabled(false);

            } else if (byroomno.isSelected()) {
                fname.setEnabled(false);
                funi.setEnabled(false);
                fid.setEnabled(false);
                froom.setEnabled(true);
            }
            else if(byuni.isSelected()){
                fname.setEnabled(false);
                funi.setEnabled(true);
                fid.setEnabled(false);
                froom.setEnabled(false);
            }
        }
    }
}

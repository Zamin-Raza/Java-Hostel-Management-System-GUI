import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ReservedGUI extends JFrame implements Serializable {
    JButton Submit, Exit, Back;
    Integer[] roomarr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    Integer[] roomarr2 = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34};
    JLabel Title, name, mob, id, roomno;
    JComboBox days, month, year, froomno;
    JTextField fname, fmob, fid;

    JCheckBox s1, s2;
    JPanel p1, p2, p3;


    ReservedGUI() {
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
//        setResizable(false);
//        setLayout(new GridLayout(2,2));
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(6, 2));
        p3.setLayout(new FlowLayout());

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        p2.setSize(30, 40);

        Title = new JLabel("CAPITAL VIEW BOYS HOSTEL");
        p1.add(Title);
        name = new JLabel("Enter Name");
        name.setSize(15, 20);
//        address = new JLabel("Enter Adress ");
        fname = new JTextField(20);
//        fadress = new JTextField(20);
        mob = new JLabel("Enter Mobile Number");
        fmob = new JTextField(20);
//        bg = new JLabel("Enter blood group");
//        fbg = new JTextField(20);
        id = new JLabel("ID");
        fid = new JTextField(20);
//        emg = new JLabel("Emergency contact");
//        femg = new JTextField(20);
//        uni = new JLabel("Institute");
        ButtonGroup g1 = new ButtonGroup();
        s1 = new JCheckBox("2-Seater", true);
        s2 = new JCheckBox("3-Seater", false);
        g1.add(s1);
        g1.add(s2);

        p2.setBackground(new Color(56, 55, 55));
        ArrayList<JLabel> lab = new ArrayList<JLabel>();
        lab.add(name);
//        lab.add(address);
//        lab.add(bg);
        lab.add(mob);
//        lab.add(uni);
//        lab.add(emg);
        lab.add(id);

        p1.setBackground(new Color(255, 222, 0));
        Title.setFont(new Font("ARIAL", 1, 22));
        Title.setForeground(new Color(255, 0, 0, 200));

        Font f2 = new Font("TIMES NEW ROMAN", 0, 18);
        fname.setFont(f2);
        fid.setFont(f2);
//        fbg.setFont(f2);


        Font f = new Font("Tahoma", 1, 16);
        for (JLabel l : lab) {
            l.setFont(f);
            l.setForeground(new Color(255, 255, 255));
        }


//        funi = new JLabel("Enter email");
//        funi = new JTextField(20);
        roomno = new JLabel("Room no ");

//        fadress.setFont(f2);
        fmob.setFont(f2);
//        femg.setFont(f2);
//        funi.setFont(f2);


//        day.addItem(dayarr);


//        froomno = new JComboBox<>();\


        froomno = new JComboBox<>(roomarr2);
        froomno.setEnabled(false);

//        MyitemListener ms = new MyitemListener();
//        froomno.addItemListener(ms);
//        froomno.setEnabled(false);
        MyActionlistener7 s = new MyActionlistener7();
        s1.addActionListener(s);
        s2.addActionListener(s);


//            days = new JComboBox<>(dayarr);
//            days.setMaximumRowCount(10);


//        temail = new JTextField(20);

        p2.add(name);
        p2.add(fname);
        p2.add(id);
        p2.add(fid);
//        p2.add(address);
//        p2.add(fadress);
        p2.add(mob);
        p2.add(fmob);
//        p2.add(uni);
//        p2.add(funi);
//        p2.add(emg);
//        p2.add(femg);
//        p2.add(bg);
//        p2.add(fbg);
        p2.add(s1);
        p2.add(s2);
        p2.add(roomno);
        p2.add(froomno);
//        p2.add(l4);
//        p2.add(t3);
//        p2.add(l5);
//        p2.add(t4);
//        p2.add(l6);
//        p2.add(t5);
//        p2.add(l7);
//        p2.add(t6);


        MyActionlistener8 as = new MyActionlistener8();


        Submit = new JButton("Submit");


//        Submit.setEnabled(false);
//        b1.addActionListener(as);
        Exit = new JButton("Exit");
        p3.add(Submit);
        Back = new JButton("Back");


        Submit.addActionListener(as);
        Exit.addActionListener(as);
        Back.addActionListener(as);
        p3.add(Exit);
        p3.add(Back);
    }

    public class MyActionlistener8 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Submit")) {
                if (fname.getText().isEmpty() || fid.getText().isEmpty() || fmob.getText().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(new JFrame(), "FIll the FIELDS");
                } else {
//

                    ArrayList<Room> rooms = new ArrayList<Room>(36);
                    rooms = FileOperations.readAllRoomsfiles();
                    Room roomadded = new Room();
                    System.out.println(froomno.getSelectedIndex());
                    int j = froomno.getSelectedIndex();
                    int i = -1;

                    if (s1.isSelected()) {
                        i = roomarr2[j];
                    } else if (s2.isSelected()) {
                        i = roomarr[j];
                    }


                    for (Room r : rooms) {
                        if (r.getNumber() == i) {
                            if (!(r.isfull())) {
                                System.out.println("1st time r ka " + r.getCurr());
                                FileOperations.updatecurrent(i);
                                System.out.println("2nd tme r ka" + r.getCurr());
                                roomadded = r;
                                roomadded.added();
                                System.out.println("First time room added ka" + roomadded.getCurr());
                                System.out.println("3r time r ka" + roomadded.getCurr());
                                if (roomadded != null) {
                                    hostelite h = new hostelite(fname.getText(), null, fmob.getText(), null, fid.getText(), null, null, new Date(02, 2, 2023), roomadded);
                                    System.out.println(h.toString());


                                        FileOperations.writeToreservedFile(h);
                                        new displaywindow(h);

//                        FileOperations.writeToFile(h);
                                        System.out.println("written successfully");
                                        System.out.println(h.room.curr);
//                        FileOperations.readFile();

                                    }

                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(new JFrame(), "NO SPACE AVAILABLE");
                                }

                            }

                        }

                    }
                }
            else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                    System.out.println("Exit successfully");
                    System.exit(1);

                } else if (e.getActionCommand().equalsIgnoreCase("Back")) {
                    dispose();
                    new MainWindow();

                    System.out.println("back successfully");

                }
            }
        }

        public class MyitemListener implements ItemListener {
//        static int i;

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    int i = roomarr[froomno.getSelectedIndex()] + 1;
                }
            }
//        public static int selectedroomno(){
//            return i;
//        }
        }

        public class MyActionlistener7 implements ActionListener {
            //
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s1.isSelected()) {
                    for (int i = 0; i < roomarr2.length; i++) {
////                        froomno.removeItem(roomarr[i]);
                        froomno.addItem(roomarr2[i]);
//
                    }
                    for (int j = 0; j < roomarr.length; j++) {
                        froomno.removeItem(roomarr[j]);
                    }
//                    froomno.addItem(roomarr);
                    froomno.setEnabled(true);

                    System.out.println("2-seater room hai bhai");
                } else if (s2.isSelected()) {
                    for (int i = 0; i < roomarr.length; i++) {
//                        froomno.removeItem(roomarr2[i]);
                        froomno.addItem(roomarr[i]);

                    }
                    for (int j = 0; j < roomarr2.length; j++) {
                        froomno.removeItem(roomarr2[j]);
                    }

//                    froomno.addItem(roomarr2);
                    System.out.println("3-Seater hai bhai");
                    froomno.setEnabled(true);
                }
            }
        }
    }




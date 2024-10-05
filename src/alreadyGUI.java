import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class alreadyGUI extends JFrame implements Serializable {
    JLabel id, mob, emg, bg, uni, adress;
    JTextField fid, funi, fbg, femg, fmob, fadress;

    JButton Submit, Exit, Back;
    JPanel p1, p2, p3;

    alreadyGUI() {

        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("HMS");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        p2.setLayout(new GridLayout(6, 2));

        id = new JLabel("ENETER ID");
        mob = new JLabel("ENTER MOBILE NUMBER");
        uni = new JLabel("ENETR INSTITUTE");
        emg = new JLabel("EMERGENCY CONATCT");
        bg = new JLabel("BLOOD GROUP");
        adress = new JLabel("ADDRESS");

        ArrayList<JLabel> labels = new ArrayList<>();
        labels.add(id);
        labels.add(adress);
        labels.add(uni);
        labels.add(mob);
//        labels.add(adress);
        labels.add(bg);
        labels.add(emg);
//        labels.add(uni);


        ArrayList<JTextField> fields = new ArrayList<>();

        fid = new JTextField(20);
        fbg = new JTextField(20);
        femg = new JTextField(20);
        funi = new JTextField(20);
        fmob = new JTextField(20);
//        fbg = new JTextFi/eld(20);
        fadress = new JTextField(20);

        fields.add(fid);
        fields.add(fadress);
        fields.add(funi);
        fields.add(fmob);
        fields.add(fbg);
        fields.add(femg);

        Submit = new JButton("Submit");
        Exit = new JButton("Exit");
        Back = new JButton("Back");

//
//        p2.add(id);
//        p2.add(fid);
//        p2.add(adress);
//        p2.add(fadress);
//        p2.add(uni);
//        p2.add(funi);
//        p2.add(mob);
//        p2.add(fmob);
//

        for (int i = 0; i < labels.size(); i++) {
            p2.add(labels.get(i));
            p2.add(fields.get(i));
        }

        p3.add(Submit);
        p3.add(Back);
        p3.add(Exit);
        MyActionlistener10 mov = new MyActionlistener10();
        Submit.addActionListener(mov);
        Back.addActionListener(mov);
        Exit.addActionListener(mov);


    }

    public class MyActionlistener10 implements ActionListener {
        //
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Submit")) {
                if (fid.getText().isEmpty() || fadress.getText().isEmpty()
                        || fmob.getText().isEmpty() || funi.getText().isEmpty() || femg.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), " FILL ALL THE FIELDS");
                } else {
                    hostelite s = FileOperations.searchreservedbyID(fid.getText());
                    if (s!=null) {
                        s.setAddress(fadress.getText());
                        s.setMobile(fmob.getText());
                        s.setEmergencyno(femg.getText());
                        s.setInstitue(funi.getText());
                        s.setBlood_group(bg.getText());
                        System.out.println("write krny wala");
                        System.out.println(s.getId());

                        FileOperations.writeToFile(s);
                        FileOperations.readFile();
                        JOptionPane.showMessageDialog(new JFrame() , "ADDED SUCCESSFULLY");
                    }
                }
            } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
                System.exit(0);

            } else if (e.getActionCommand().equalsIgnoreCase("Back")) {
                new optionalAddGUI();
                dispose();
            }
        }
    }
}

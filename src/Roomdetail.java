import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Roomdetail extends JFrame {
    Container c;
JLabel floor,number,curr,type;
JButton back;


JLabel ffloor,fnumber,fcurr,ftype;
    Roomdetail(Room r){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ROOM DETAILS");
        setLayout(null);

        c = this.getContentPane();

        c.setLayout(null);

        floor = new JLabel("FLOOR : ");
        number = new JLabel("ROOM NUMBER : ");
        curr = new JLabel("CURRENT STUDENTS :");
        type = new JLabel("CAPACITY : ");

        back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("Back")){
                    new searchoptional();
                    dispose();
                }
            }
        });

        ffloor = new JLabel(Integer.toString(r.getFloor()));
        fnumber = new JLabel(Integer.toString(r.getNumber()));
        fcurr = new JLabel(Integer.toString(r.getCurr()));
        ftype = new JLabel(Integer.toString(r.getSeater()));

        floor.setBounds(30,60,180,30);
        ffloor.setBounds(200,60,180,30);
        number.setBounds(30,120,180,30);
        fnumber.setBounds(200,120,180,30);
        curr.setBounds(30,180,180,30);
        fcurr.setBounds(200,180,180,30);
        type.setBounds(30,240,180,30);
        ftype.setBounds(200,240,180,30);
        back.setBounds(200,320,120,30);

        back.setForeground(new Color(233,2,2));
        back.setBackground(new Color(255,255,255));


        Font f = new Font("AGENCY FB",1,20);


        ArrayList<JLabel> l = new ArrayList<>(8);
        l.add(floor);
        l.add(ffloor);
        l.add(number);
        l.add(fnumber);
        l.add(curr);
        l.add(fcurr);
        l.add(type);
        l.add(ftype);

//        c.add(fnumber);


        for (JLabel p : l){
            c.add(p);
            p.setFont(f);
        }
        c.add(back);

        setVisible(true);







    }
}

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

public static void writeroom(Object o){

    try {
        File f = new File("ALLROOMS.txt");
        ObjectOutputStream oos;
        if (f.exists()) {
            oos = new MyobjectoutputStream(new FileOutputStream(f, true));
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(f));
        }
        oos.writeObject(o);
        oos.close();
    } catch (Exception e) {
        System.out.println("Error: ");
        e.printStackTrace();
    }
}
    public static void readRoomFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("ALLROOMS.txt"));

            while (true) {
                Room s = (Room) is.readObject();
                System.out.println(s.toString());
            }

        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }


    public static void writeToFile(Object o) {

//
        if (o.getClass().getName().equalsIgnoreCase("Room")) {

            writeroom(o);
        } else {
            try {
                File f = new File("ALLSTUDENTS.txt");
                ObjectOutputStream oos;
                if (f.exists()) {
                    oos = new MyobjectoutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(o);
                oos.close();
            } catch (Exception e) {
                System.out.println("Error: ");
                e.printStackTrace();
            }
        }
    }

    public static void writeToreservedFile(Object o) {

            try {
                File f = new File("reserved3.txt");
                ObjectOutputStream oos;
                if (f.exists()) {
                    oos = new MyobjectoutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(o);
                oos.close();
            } catch (Exception e) {
                System.out.println("Error: ");
                e.printStackTrace();
            }
        }

    public  static ArrayList<hostelite> readAllreservedfiles(){
        ArrayList<hostelite> arr = new ArrayList<hostelite>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("reserved3.txt"));

            while (true) {
                hostelite s = (hostelite) is.readObject();
                arr.add(s);

            }


        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
        return arr;
    }





    public static void readFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("ALLSTUDENTS.txt"));

            while (true) {
                hostelite s = (hostelite) is.readObject();
                System.out.println(s.toString());
            }

        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
    public static void readreservedFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("reserved3.txt"));

            while (true) {
                hostelite s = (hostelite) is.readObject();
                System.out.println(s.toString());
            }

        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
    public  static ArrayList<Room> readAllRoomsfiles(){
        ArrayList<Room> arr = new ArrayList<Room>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("ALLROOMS.txt"));

            while (true) {
                Room s = (Room) is.readObject();
                arr.add(s);

            }


        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
        return arr;
    }
//



    public  static ArrayList<hostelite> readAllfiles(){
        ArrayList<hostelite> arr = new ArrayList<hostelite>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("ALLSTUDENTS.txt"));

            while (true) {
                hostelite s = (hostelite) is.readObject();
                arr.add(s);

            }


        } catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
        return arr;
    }

    public static Room specificroom(int check){
    ArrayList<Room> ro = new ArrayList<>();
    ro = FileOperations.readAllRoomsfiles();
    for (Room kamry: ro){
        if (kamry.getNumber()==check){
            return kamry;
        }
    }
    return null;

    }
    public  static hostelite searchreservedbyID(String check){
        ArrayList<hostelite> d = readAllreservedfiles();
        for(hostelite i : d){
            if(i.getId().equalsIgnoreCase(check)){
                System.out.println("mill gya");
                return i;
            }
        }
        return null;
    }

    public static hostelite searchbyname(String naam){
        ArrayList<hostelite> p = readAllfiles();
//        p = readAllfiles();
        for(hostelite i : p){
            if(i.getName().equalsIgnoreCase(naam)){
                System.out.println("desired data");
                return i;
            }
            else {
                System.out.println("NOT FOUNDED");
            }
        }
        return null;
    }

    public static boolean searchidalready(String id){
        ArrayList<hostelite> p = readAllfiles();
        boolean f = false;
//        p = readAllfiles();
        for(hostelite i : p){
            if(i.getId().equalsIgnoreCase(id)){
                System.out.println("ALREADY EXIST");
                return true;
            }
            else {
                System.out.println("NOT FOUNDED");
            }
        }
        return f;
    }

    public static  void delete(String id) {
        ArrayList<hostelite> r = readAllfiles();


        for (hostelite i : r) {
            if (i.getId().equalsIgnoreCase(id)) {
                System.out.println("founded");
                r.remove(i);
                break;
            }
        }

        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : r) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }


    public static hostelite searchbyroomno(int no){
        ArrayList<hostelite> r = readAllfiles();
        for(int i = 0 ; i<r.size() ; i++){

            if(r.get(i).room.getNumber() == no){
                return (r.get(i));
            }
            else{
                System.out.println("Not founded");
            }
        }
        return null;
    }

    public  static hostelite searchbyID(String id){
        ArrayList<hostelite> d = readAllfiles();
        for(hostelite i : d){
            if(i.getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return null;
    }
    public  static void searchbymob(String m){
        ArrayList<hostelite> d = readAllfiles();
        for(hostelite i : d){
            if(i.getId().equalsIgnoreCase(m)){
                System.out.println(i.toString());
            }
        }
    }

    public static  void updateroom(int check,int number){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getRoom().getNumber() == number){
                g.setRoom(new Room(1,2,number,'B'));
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }
    public static  void updatecurrent(int check){
        ArrayList<Room> n = readAllRoomsfiles();
        for(Room g : n){
            if(g.getNumber() == check){
                System.out.println("crucial" + g.getCurr());
                g.setCurr(1+g.getCurr());
                System.out.println("ye new curr" + g.getCurr());
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLROOMS.txt"))) {
                for (Room g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }


    public static  void delcurrent(int check){
        ArrayList<Room> n = readAllRoomsfiles();
        for(Room g : n){
            if(g.getNumber() == check){
                System.out.println("crucial" + g.getCurr());
                g.setCurr(g.getCurr() - 1);
                System.out.println("ye new curr" + g.getCurr());
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLROOMS.txt"))) {
                for (Room g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }




    public static  void updatefine(String check,String number){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.getBill().setFine(Integer.parseInt(number));
                System.out.println(g.getBill().getDues());
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public static  void updateconcession(String check,String number){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.getBill().setConcession(Integer.parseInt(number));
//                System.out.println(g.getBill().getDues());
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }


    public static  void updatemob(String check,String number){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.setMobile(number);
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public static  void updatename(String check,String name){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.setName(name);
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public static  void updateadress(String check,String adress){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.setAddress(adress);
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }


    public static  void updatebill(String check, int a){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(check)){
                g.getBill().setFine(0);


                g.getBill().setDues((int) (g.totalrent() - a));
                System.out.println(g.getBill().getDues());
                g.getBill().setRegestered(true);
                if(g.totalrent() == a){
                    g.getBill().setPaid(true);
                }

                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public static  ArrayList<hostelite> allsameuni(String inst){
    ArrayList<hostelite> s = new ArrayList<hostelite>();
    ArrayList<hostelite> all = new ArrayList<hostelite>();
    s=readAllfiles();
    for (hostelite k : s){
        if (k.getInstitue().equalsIgnoreCase(inst)){
            all.add(k);
        }
    }
    return all;
    }


    public static  ArrayList<hostelite> allsameroom(String inst){
        ArrayList<hostelite> s = new ArrayList<hostelite>();
        ArrayList<hostelite> all = new ArrayList<hostelite>();
        s=readAllfiles();
        for (hostelite k : s){
            if (k.getInstitue().equalsIgnoreCase(inst)){
                all.add(k);
            }
        }
        return all;
    }









    public static void searchreadFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("test3.txt"));
            Scanner input = new Scanner(System.in);
            System.out.println("PRESS 1-SEARCH BY NAME\n 2-SEARCH BY ROOM NUMBER \n  3-SEARCH BY ID\n 4-SEARCH BY MOB \n");
            int val = input.nextInt();

            if(val == 1){
                System.out.println("enter name you want to search");
                String name = input.next();
                searchbyname(name);

            }
            else if(val == 2) {
                int num = input.nextInt();
                searchbyroomno(num);
            }

            else if(val == 3) {
                String i = input.next();
                searchbyID(i);

            }

            else if(val == 4) {
                String mob = input.next();

                searchbymob(mob);
            }
            else{
                System.out.println("invalid");
            }
        }
        catch (FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF!");

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
    public static  void updatebill(hostelite h,double s){
        ArrayList<hostelite> n = readAllfiles();
        for(hostelite g : n){
            if(g.getId().equalsIgnoreCase(h.getId())){
                g.paybill(s);
                break;
            }
        }
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ALLSTUDENTS.txt"))) {
                for (hostelite g : n) {
                    oos.writeObject(g);
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
    }

}








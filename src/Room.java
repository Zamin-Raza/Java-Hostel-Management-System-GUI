import java.io.Serializable;

public class Room implements Serializable {
    int floor;
    int number;
    int seater;

    boolean reserved;

    int curr;
    char type;


    public int getFloor() {
        return floor;
    }
    public Room(int a, int b,int c, char d){
        this.floor=a;
        this.number = b;
        this.seater = c;
        this.type = d;

    }
    public Room(int num){
        this.number = num;
    }
    public Room(){
        this.floor = 0;
        this.number = 0;
        this.seater =0;
        this.type='a';
    }
    public boolean isfull(){
        return (this.curr==this.seater?true:false);
    }

    public  void added(){
        curr++;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public char getType() {
        return type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeater() {
        return seater;
    }

    public void setSeater(int seater) {
        this.seater = seater;
    }

    public void setsFloor() {
        if (this.number>= 0 && this.number<9){
            this.floor = 0;
        }
        else if( this.number>=9 && this.number <=17){
            this.floor = 1;
        }
        else if( this.number>=18 && this.number <=26){
            this.floor = 2;
        }
        else if( this.number>=27 && this.number <=35){
            this.floor = 3;
        }
    }
    public void setsSeater(){
        if(this.type != 'O' && this.number % 2 == 0){
            this.seater = 2;
        }
        else if(this.type != 'O' && this.number % 2 != 0){
            this.seater = 3;
        }

    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +"\n"+
                "floor=" + floor +"\n"+
                "number=" + number +"\n"+
                "seater=" + seater +"\n"+
                "type=" + type +"\n"+
                "current=" + curr+
                '}';
    }
}

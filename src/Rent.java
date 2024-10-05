import java.io.Serializable;

public class Rent implements Serializable {
    boolean paid;
    int fine;
    int dues;
    int concession;
    boolean regestered;

    Rent(int fine,int conc,boolean reg, boolean paid){
        this.concession=conc;
        this.dues = 13000;
        this.fine =fine;
        this.regestered =reg;
        this.paid = paid;

    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isRegestered() {
        return regestered;
    }

    public int getDues() {
        return dues;
    }

    public boolean getpaid(){
        return this.paid;
    }


    public int getFine() {
        return fine;
    }

    public int getConcession() {
        return concession;
    }

    public void setDues(int dues) {
        this.dues = dues;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void setConcession(int concession) {
        this.concession = concession;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setRegestered(boolean regestered) {
        this.regestered = regestered;
    }

    @Override
    public String toString() {
        return "Rent{" +"\n"+
                "paid=  " + paid +"\n"+
                "fine=" + fine +"\n"+
                "dues=" + dues +"\n"+
                "concession=" + concession +"\n"+
                "regestered=" + regestered +"\n"+
                '}';
    }

}

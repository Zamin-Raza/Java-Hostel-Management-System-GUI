import java.io.Serializable;

public class Date implements Serializable {
    int month;
    int date;
    int year;

    Date(int a, int b, int c ){
        this.month = checkmonth(b);
        this.year = c;
        this.date = a;

    }
    public int checkmonth(int testmonth){
        if(testmonth> 0 && testmonth <=12){
            return testmonth;
        }
        else {
            System.out.println("Invalid month");
            return 1;
        }
    }
    public int checkday(int testday) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (testday <= days[this.month]) {
            return testday;
        }
        if (month == 2 && testday == 29 && (year % 4 == 0 || year % 4 == 0 || year % 100 != 0)) {
            return testday;
        } else {
            System.out.println("invalid date");
            return 1;
        }
    }

    public int checkyear(int testyear){
        if(testyear >= 2022){
            return  testyear;
        }
        else{
            System.out.println("invalid year");
            return 1;
        }

    }

    @Override
    public String toString() {
        return (month +"-"+date+"-"+year);
    }

}

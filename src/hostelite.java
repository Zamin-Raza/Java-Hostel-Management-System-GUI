public class hostelite extends Person{
    private String id;
    private String emergencyno;
    private String institue;
    Date dateofadmission;
    Room room;

    Rent bill;
    public hostelite(String name, String addr, String mob, String bg,String id , String eme , String inst , Date
                     addmission, Room room) {
        super(name, addr, mob, bg);
        this.dateofadmission = addmission;
        this.institue = inst;
        this.emergencyno = eme;
        this.room = room;
        this.id = id;
        this.bill = new Rent(0,0,false,false);
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    public Date getDateofadmission() {
        return dateofadmission;
    }

    public String getEmergencyno() {
        return emergencyno;
    }

    public void setDateofadmission(Date dateofadmission) {
        this.dateofadmission = dateofadmission;
    }

    public String getInstitue() {
        return institue;
    }

    public String getId() {
        return id;
    }

    public void setInstitue(String institue) {
        this.institue = institue;
    }

    public void setEmergencyno(String emergencyno) {
        this.emergencyno = emergencyno;
    }

    public double totalrent () {
        int roomrent;
        if (this.getBill().getpaid()){
            return 0;
        }
        if (this.room.seater == 2) {
            roomrent = this.getBill().getDues() + 2000;
        } else {
            roomrent = this.getBill().getDues();
        }
        if (!(this.bill.isRegestered())) {
            return (this.bill.getFine() +  4000 + (roomrent - this.bill.concession));
        } else {
            return (this.bill.getFine()  + (roomrent - this.bill.concession));
        }
    }
    public void paybill ( double x){
        double y = this.totalrent() - x;

        this.bill.setDues((int) y);
        this.bill.setFine(0);
        this.bill.setPaid(true);
        this.bill.setRegestered(true);


    }

    public Rent getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return (super.toString() + this.emergencyno + this.institue + "your ID " +this.id
                + this.room.toString() + this.dateofadmission.toString());
    }
}

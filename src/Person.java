import java.io.Serializable;

public class Person implements Serializable {
String name;
String address;
String mobile;
String blood_group;

public Person(String a , String b , String c , String d){
    name = a;
    address = b;
    mobile = c;
    blood_group = d;
}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public String getMobile() {
        return mobile;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", blood_group='" + blood_group + '\'' +
                '}';
    }
}

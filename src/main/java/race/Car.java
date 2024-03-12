package race;

public class Car {

    private String mileage = "";

    public String getMileage() {
        return this.mileage;
    }

    public void go() {
        this.mileage += "-";
    }

}

package race;

public class Car {

    private String mileage = "-";

    public String goForward(int no) {
        for (int i = 2; i <= no; i++) {
            this.mileage += "-";
        }
        return this.mileage;
    }
}

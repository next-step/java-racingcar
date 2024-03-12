package race;

import java.util.Random;

public class Car {

    private String mileage = "";

    public String getMileage() {
        return this.mileage;
    }

    public void go(int numberOfAttempts) {
        if (numberOfAttempts > 0) {
            if (new Random().nextInt(10) >= 4) {
                this.mileage += "-";
            }
        } else {
            this.mileage += "-";
        }
    }

}

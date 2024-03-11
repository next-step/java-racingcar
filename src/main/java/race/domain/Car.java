package race.domain;

public class Car {

    public String go(int count) {
        String mileage = "-";
        for (int i = 0; i < count; i++) {
            mileage += "-";
        }
        return mileage;
    }

}

package race;

public class Car {

    public String goForward(int no) {
        String mileage = "-";
        for (int i = 2; i <= no; i++) {
            mileage += "-";
        }
        return mileage;
    }
}

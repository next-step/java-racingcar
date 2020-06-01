package step4;

public class Car {

    private int position = 0;
    private final static int MINIMUM_CONDITIONS = 4;
    private String carName;

    public Car(String inputCarName) {
        this.carName = inputCarName;
    }

    public void goPosition() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean canGo(int number) {

        return number >= MINIMUM_CONDITIONS ? true : false;
    }

}

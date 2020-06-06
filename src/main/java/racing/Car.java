package racing;

public class Car {

    private int position = 0;
    private final static int MINIMUM_CONDITIONS = 4;
    private String carName;

    public Car(String inputCarName) {
        this.carName = inputCarName;
    }

    public Car(String inputCarName, int position) {
        this.carName = inputCarName;
        this.position = position;
    }

    private void decidePosition(boolean greaterCheck) {
        if (greaterCheck) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public void move(int number) {
        decidePosition(number >= MINIMUM_CONDITIONS ? true : false);
    }

    public boolean isSamePosition(Integer inputposition) {
        return position == inputposition;
    }

}

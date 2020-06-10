package racing.domain;

import racing.utils.Valid;

public class Car implements Comparable<Car> {

    private final static int MINIMUM_CONDITIONS = 4;
    private int position;
    private String carName;

    public Car(String inputCarName) {
        this(inputCarName, 0);
    }

    public Car(String inputCarName, int position) {

        Valid.isEmpty(inputCarName);
        Valid.positionMinusCheck(position);

        this.carName = inputCarName;
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public void move(int number) {
        if (canMove(number)) {
            this.position++;
        }
    }

    private boolean canMove(int number) {
        return number >= MINIMUM_CONDITIONS;
    }

    public boolean isSamePosition(Integer inputposition) {
        return position == inputposition;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }
}

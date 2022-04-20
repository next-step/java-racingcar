package racing.module;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private final CarName carName;
    private int position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = DEFAULT_POSITION;
    }

    public void attempt(MoveStrategy strategy) {
        if (strategy.canMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Boolean checkPosition(int position) {
        return this.position == position;
    }

    public String getCarName() {
        return carName.getName();
    }
}

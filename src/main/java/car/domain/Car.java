package car.domain;

public class Car {
    private final int MOVING_LIMIT = 4;
    private CarName name;
    private int position = 0;

    public Car(String carName) {
        this.name = new CarName(carName);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    // 자동차는 무조건 움직인다.
    public void move(int amount) {
//        int randomNum = NumberGenerator.getRandomNumber();
//        if (randomNum >= MOVING_LIMIT) {
//            this.position.increasePosition();
//        }
        this.position++;
    }

}

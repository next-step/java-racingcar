package CarRacing;

public class Car {

    private Position position;
    private CarName carName;

    public Car(CarName carName) {
        this.position = new Position();
        this.carName = carName;
    }

    public void move(int randomNum) {
        if (randomNum < 0) {
            throw new IllegalArgumentException("posision은 음수 값을 가질 수 없습니다.");
        }
        position.increasePosition(randomNum);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }


}

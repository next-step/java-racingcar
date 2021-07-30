package CarRacing;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
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


}

package study.race;

public class Car {

    private CarName carName;
    private int moved = 0;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public void move() {
        moved++;
    }

    public String getName() {
        return carName.getName();
    }

    public int getScore() {
        return moved;
    }

}

package car.domain;

public class Car {
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

    public void move(int amount) {
        this.position+= amount;
    }

}

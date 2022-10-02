package step4.domain;

public class Car {

    private CarProperty carProperty;

    public Car(String name) {
        this.carProperty = new CarProperty(name);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.carProperty = new CarProperty(
                    carProperty.getName(), carProperty.getStep() + 1);
        }
    }

    public CarProperty getCarProperty() {
        return this.carProperty;
    }
}

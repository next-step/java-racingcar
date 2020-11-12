package carRace.step5.domain;


import carRace.step5.domain.util.CarDataCheck;

public class Car {
    private String carName;
    private int moveDistance;
    private static int referenceValue = 4;

    public Car(String carName) {
        CarDataCheck carDataCheck = new CarDataCheck();

        carDataCheck.checkNumberValue(carName);

        this.carName = carName;
        this.moveDistance = 0;
    }

    public Car(String carName, int moveDistance) {
        this.carName = carName;
        this.moveDistance = moveDistance;
    }

    public Car(Car car) {
        this.carName = car.getCarName();
        this.moveDistance = car.getMoveDistance();
    }

    public void moveCar(int carPower) {
        if (carPower > 4) {
            this.moveDistance++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}

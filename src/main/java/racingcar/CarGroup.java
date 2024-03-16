package racingcar;

public class CarGroup {
    Car[] carGroup;

    public CarGroup() {
        carGroup = new Car[0];
    }

    public void resizeCarArray(int numOfCar) {
        carGroup = new Car[numOfCar];
        for (int i = 0; i < numOfCar; i++) {
            carGroup[i] = new Car();
        }
    }

    public void updateCarArrayPosition() {
        for (int i = 0; i < carGroup.length; i++) {
            carGroup[i].updatePosition();
        }
    }

    public int carGroupLength() {
        return carGroup.length;
    }

    public int position(int carIndex) {

        return carGroup[carIndex].position();
    }
}

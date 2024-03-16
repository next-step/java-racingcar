package racingcar;

public class CarGroup {
    Car[] carGroup;
    int numOfCar;

    public CarGroup() {
        numOfCar = 0;
        carGroup = new Car[0];
    }

    public void resizeCarArray(int NumOfCar) {
        this.numOfCar = NumOfCar;
        carGroup = new Car[numOfCar];
        for (int i = 0; i < numOfCar; i++) {
            carGroup[i] = new Car();
        }
    }

    public void updateCarArrayPosition() {
        for (int i = 0; i < numOfCar; i++) {
            carGroup[i].updatePosition();
        }
    }

    public int position(int carIndex) {

        return carGroup[carIndex].position();
    }
}

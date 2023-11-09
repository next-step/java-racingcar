package study.carRacing;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {

    private ReceiveInputValue receiveInputValue;
    private Random random;
    private ViewResult viewResult;

    public CarRacing() {
        this.receiveInputValue = new ReceiveInputValue();
        this.random = new Random();
        this.viewResult = new ViewResult();
    }

    public void runCarRacing() {

        int numberOfCar = receiveInputValue.receiveInputValueForCar();
        int roundOfTrack = receiveInputValue.receiveInputValueForRound();

        ArrayList<Car> CarList = generateCarList(numberOfCar);

        for (int i = 0; i < roundOfTrack; i++) {
            runTrack(CarList);
            this.viewResult.printResult(CarList);
        }

    }

    public ArrayList<Car> generateCarList(int numberOfCar) {
        ArrayList<Car> CarList = new ArrayList<Car>();
        for (int i = 0; i < numberOfCar; i++) {
            CarList.add(new Car(i+1));
        }
        return CarList;
    }

    public void runTrack(ArrayList<Car> CarList) {
        for (int j = 0; j < CarList.size(); j++){
            int movingDistance = this.random.nextInt(10);
            Car car = CarList.get(j);
            car.move(movingDistance);
        }
    }


}

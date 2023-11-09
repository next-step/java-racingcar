package study.carRacing;

import java.util.ArrayList;

public class ViewResult {

    public void printResult(ArrayList<Car> CarList) {
        for (int i = 0; i <CarList.size(); i++) {
            Car car = CarList.get(i);
            printMovingDistance(car);
        }
        System.out.println("");
    }

    private void printMovingDistance(Car car) {
        int movingDistance = car.getMovingDistance();
        System.out.println("Car" + String.valueOf(car.getCarNumber()) + " " + "-".repeat(movingDistance));
    }


}

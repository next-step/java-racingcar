package study.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {
        String value = InputView.scanNumberOfCar();
        int racingCount = InputView.scanNumberOfCount();

        int carNumber = Integer.parseInt(value);
        ArrayList carRacingArray = carArray(carNumber);

    }

    public static ArrayList carArray(int carNumber) {
        ArrayList<Car> carList = new ArrayList<>();
        for(int i = 0; i < carNumber; i++) {
            Car car = new Car();
            carList.add(car);
        }
        return carList;
    }
}

class Car{
    int position = 1;
}


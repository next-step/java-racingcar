package study.race;

import java.util.ArrayList;

public class CarRacing {

    public static void main(String[] args) {
        String value = InputView.scanNumberOfCar();
        int racingCount = InputView.scanNumberOfCount();

        int carNumber = Integer.parseInt(value);
        ArrayList carRacingArray = carArray(carNumber);

    }

    public static ArrayList carArray(int carNumber) {
        ArrayList<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            Car car = new Car();
            carList.add(car);
        }
        return carList;
    }

    public static int condition(int number) {
        if (number >= 4) {
            return 1;
        }
        return 0;
    }

}

class Car {
    int position = 1;
}


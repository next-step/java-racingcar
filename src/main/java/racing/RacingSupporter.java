package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingSupporter {
    public static void judgeRace(Car car, int number) {
        if(number > 3) {
            car.move();
        }
    }

    public static void raceCars(Cars cars, List<Integer> randomList) {
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < carList.size(); i++) {
            judgeRace(carList.get(i),randomList.get(i));
        }
    }


    public static List<Car> generateCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

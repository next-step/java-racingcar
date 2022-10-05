package study;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static study.Number.getRandom;

public class RacingGame {

    public static List<Car> makeCarList(int count) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++){
            carList.add(new Car());
        }
        return carList;
    }

    public static Cars carTryMove(Cars cars, int count){
        for(Car car : cars.getList()) {
            carMoveCount(car, count);
        }
        return cars;
    }

    private static void carMoveCount(Car car,int count) {
        for(int i = 0; i < count; i++) {
            car.move(getRandom());
        }
    }


}
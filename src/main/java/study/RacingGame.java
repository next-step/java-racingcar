package study;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_NUMBER = 10;

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

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(new RandomNumber(RANDOM_NUMBER).getValue());
    }


}
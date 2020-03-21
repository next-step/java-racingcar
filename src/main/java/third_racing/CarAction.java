package third_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarAction {

    private static final int ALLOW_MOVE_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int RANDOM_MIN_NUMBER = 0;

    public CarAction() {
    }

    public static List<Car> firstSet(int carNo) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNo; i++) {
            Car car = new Car();
            car.carPartIn(i+1);

            carList.add(car);
        }
        return carList;
    }

    public List<Car> moveCar(int carNo, int tryNo) {
        List<Car> carList = firstSet(carNo);

        Resultview resultview = new Resultview();
        resultview.getTitle();

        for (int i = 0; i < tryNo ; i++) {
            move(carList);
            resultview.getDivideLine();
        }
        return carList;
    }

    private void move(List<Car> carList) {
        Resultview resultview = new Resultview();
        for (int i = 0; i < carList.size(); i++) {

            Car car = new Car();
            car = carList.get(i);
            resultview.draw(car);

            isMove(car);
        }
    }

    public static void isMove(Car car) {
        if (random() < ALLOW_MOVE_NUMBER) {
            car.move();
        }

        return;
    }

    public static int random() {
        int randomValue = new Random().nextInt(RANDOM_MAX_NUMBER+1) + RANDOM_MIN_NUMBER;

        if (randomValue < RANDOM_MIN_NUMBER || randomValue > RANDOM_MAX_NUMBER){
            throw new IllegalArgumentException(RANDOM_MIN_NUMBER + "~" + RANDOM_MAX_NUMBER+1 + "만 허용");
        }

        return randomValue;
    }
}
package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarFactory {
    private CarFactory() {
        throw new RuntimeException("인스턴스화가 불가능한 클래스입니다.");
    }

    public static List<Car> manufactoringCars(String nameListOfCars, int tryingCount) {
        String[] carNameList = getCarNameList(nameListOfCars);
        List<Car> cars = new ArrayList<>(carNameList.length);
        for (String s : carNameList) {
            cars.add(new Car(s, tryingCount));
        }
        return cars;
    }

    private static String[] getCarNameList(String nameListOfCars) {
        return nameListOfCars.split(",");
    }
}

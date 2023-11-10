package racing.util;

import racing.Car;
import racing.type.CarName;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    private static final String DELIMITER = ",";

    /**
     * 전부 기본값으로 값이 세팅된 자동차를 지정된 개수만큼 반환합니다.
     *
     * @param theNumberOfCars 생성할 자동차 개수
     *
     * @return 생성된 자동차 목록
     */
    public static List<Car> createMultipleDefaultCars(int theNumberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < theNumberOfCars; i++) {
            carList.add(Car.create());
        }
        return carList;
    }

    /**
     * 구분자로 구분되는 이름 목록을 주면 그 이름대로 자동차들을 만들어서 반환합니다.
     *
     * @param multiNameString 생성할 이름 목록
     *
     * @return 생성된 자동차 목록
     */
    public static List<Car> createByMultiNameString(String multiNameString) {
        if (multiNameString == null || multiNameString.isEmpty()) {
            return new ArrayList<>();
        }

        List<Car> carList = new ArrayList<>();

        String[] nameList = multiNameString.split(DELIMITER);

        for (String name : nameList) {
            carList.add(
                    Car.createWithName(new CarName(name))
            );
        }

        return carList;
    }
}

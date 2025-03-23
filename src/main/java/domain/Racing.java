package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Racing {
    private final List<Car> carList = new ArrayList<>(); // 자동차 리스트

    /**
     * @param carNames
     * 레이싱 초기화
     */
    public Racing(List<String> carNames) {
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }

    /**
     * 레이싱 시작
     */
    public void start() {
        for (Car car : carList) {
            int randomNo = RandomUtil.generate();
            car.move(randomNo);
        }
    }

}

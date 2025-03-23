package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * @return 우승자를 찾습니다.
     */
    private List<Car> findWinner() {
        int maxScore = carList.stream().mapToInt(Car::getPosition).max().orElse(0);

        return carList.stream().filter(car -> car.getPosition() == maxScore).collect(Collectors.toList());
    }


}

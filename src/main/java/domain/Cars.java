package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 자동차 그룹 클래스
 */
public class Cars {

    public final List<Car> cars;
    private final Random random = new Random();
    private final int MAX_BOUND = 10;

    public Cars(String names) {
        this(Arrays.stream(names.split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public Cars(List<Car> carList) {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 한 대 이상 있어야 합니다.");
        }
        this.cars = carList;
    }

    /**
     * 자동차 전체 이동 메서드
     */
    public void moveAll() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    /**
     * 랜덤한 위치 뽑기
     */
    private int getRandomNumber() {
        return random.nextInt(MAX_BOUND);
    }

    /**
     * 자동차 전체 위치 확인 메서드
     */
    public String printCarPositionAll() {
        StringBuilder sb = new StringBuilder();
        this.cars
            .forEach(car -> {
                sb.append(car.printPosition()).append("\n");
            });
        return sb.toString();
    }

    /**
     * 최대 위치 찾는 메서드
     */
    public Position findMaxPosition() {
        return cars.stream()
            .map(car -> car.position)
            .max(Position::compareTo)
            .orElse(new Position(0));
    }
}

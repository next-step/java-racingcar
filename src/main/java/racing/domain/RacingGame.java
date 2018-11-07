package racing.domain;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 레이싱 게임
 */
public class RacingGame {
    private static final int ZERO = 0;
    private static final int BOUND = 10;
    private final Random random = new Random();
    private List<Car> cars;
    private int time;

    public List<Car> getCars() {
        return cars;
    }

    /**
     * 초기화
     *
     * @param names
     * @param time
     * @throws NoSuchAlgorithmException
     */
    public RacingGame(String[] names, int time) {
        this.time = time;
        cars = new ArrayList<>();

        // 차 넣기
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    /**
     * 이동
     *
     * @return
     */
    public List<Car> move() {
        for (Car car : cars) {
            car.move(random.nextInt(BOUND));
        }

        --time;
        return cars;
    }

    /**
     * 게임이 진행 가능한지 여부
     *
     * @return
     */
    public boolean canContinue() {
        return time > ZERO;
    }


    /**
     * 우승자 가져오기
     *
     * @return
     */
    public static List<Car> getWinners(List<Car> cars) {
        final Integer maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .collect(Collectors.toList());
    }

    /**
     * 가장 멀리간 위치 값 가져오기
     *
     * @return
     */
    public static Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }
}

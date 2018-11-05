package racing;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 레이싱 게임
 */
public class RacingGame {
    private static final int ZERO = 0;
    private List<Car> cars;
    private int time;

    /**
     * 초기화
     *
     * @param names
     * @param time
     * @throws NoSuchAlgorithmException
     */
    public RacingGame(String[] names, int time) throws NoSuchAlgorithmException {
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
            car.move();
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
    public List<Car> getWinners() {
        return cars.stream()
                .filter(c -> {
                    return c.getPosition().intValue() == getMaxPosition().intValue();
                })
                .collect(Collectors.toList());

    }

    /**
     * 가장 멀리간 위치 값 가져오기
     *
     * @return
     */
    public Integer getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }
}

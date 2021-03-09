package step3.domain;

import step3.move.ConditionMoveStrategy;
import step3.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static step3.util.Constants.START_IDX;

/**
 * 자동차의 생성을 관리할 클래스
 */
public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    // 자동차 댓수만 설정
    public CarManager(final int participants) {
        this(participants, new ConditionMoveStrategy());
    }

    // 자동차 움직이는 전략과 함께 생성하려는 경우
    public CarManager(final int carCount, final MoveStrategy moveStrategy) {
        createCars(carCount, moveStrategy);
    }

    // 자동차 생성 메서드
    private void createCars(int carCount, MoveStrategy moveStrategy) {
        IntStream.range(START_IDX, carCount)
                .forEach(value -> cars.add(new Car(START_IDX, moveStrategy)));
    }

    // 자동차 이동 메서드
    public RacingRound run() {
        List<Car> movedCars = cars.stream()
                .map(Car::move)
                .collect(toList());

        // 라운드 마다 새로운 객체로 생성하여 관리
        return new RacingRound(movedCars);
    }

    public List<Car> getCars() {
        return cars;
    }
}

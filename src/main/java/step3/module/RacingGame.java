package step3.module;

import step3.domain.Car;
import step3.domain.CarGenerator;
import step3.domain.RandomGenerator;
import step3.domain.Record;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static step3.util.Constants.*;

/**
 * 레이싱 게임 역할을 하는 클래스
 */
public class RacingGame implements RacingGameRunnable {

    private final RandomGenerator randomGenerator;

    public RacingGame() {
        this.randomGenerator = new RandomGenerator(RANDOM_RANGE_BOUND);
    }

    @Override
    public void run() {
        // 사용자의 요청 값을 입력
        InputView inputView = new InputView();
        int carCount = inputView.requestUserInput(QUESTION_HOW_MANY_CAR);
        int tryCount = inputView.requestUserInput(QUESTION_HOW_MANY_TRY);

        // 자동차 생성
        List<Car> cars = CarGenerator.of(carCount);

        // 레이싱 결과
        List<Record> record = race(cars, tryCount);

        // 결과 출력
        ResultView resultView = new ResultView();
        resultView.responseResult(record);
    }

    // 자동차 레이싱 로직
    private List<Record> race(List<Car> participants, int tryCount) {
        List<Record> resultRecord = new ArrayList<>();

        // TODO 뭔가 다르게 할 수 있는 방법은 없는지 생각하기
        while (tryCount-- > 0) {
            resultRecord = attempt(participants);
        }
        return resultRecord;
    }

    // 1회 시도당 레이서의 이동 거리 move() -> record 기록
    private List<Record> attempt(List<Car> participants) {
        return participants.stream()
                .map(car -> car.move(randomGenerator.generateOneToTen()))
                .map(Car::toRecord)
                .collect(Collectors.toList());
    }
}

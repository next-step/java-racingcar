package racinggame.domain.racing;

import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Car의 List 필드
 * 1. 레이싱 1 라운드를 진행
 * 1. 전체 라운드 수 만큼 자동차 이동
 * 1. 라운드 결과 저장
 * 1. 우승자 찾기
 */
public class Racing {
    private RacingCars racingCars;
    private int gameCount;
    private List<RoundResult> roundResult = new ArrayList<>();

    public Racing(int gameCount, List<String> carNames) {
        this.gameCount = gameCount;
        this.racingCars = createRacingCars(carNames);
    }

    private RacingCars createRacingCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        int carNamesListSize = carNames.size();

        for (int i = 0; i < carNamesListSize; i++) {
            cars.add(new Car(carNames.get(i)));
        }

        return new RacingCars(cars);
    }

    private void playOneRound() {
        this.racingCars.moveCarAll();
        saveRoundResult();
    }

    private void saveRoundResult() {
        this.roundResult.add(new RoundResult(this.racingCars));
    }

    public void playAllRound() {
        for (int i = 0; i < this.gameCount; i++) {
            playOneRound();
        }
    }

    public List<RoundResult> getRoundResult() {
        return this.roundResult;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}

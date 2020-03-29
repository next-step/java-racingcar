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
    private RoundResult roundResult;

    public Racing(List<String> carNames, int gameCount) {
        this.gameCount = gameCount;
        this.racingCars = createRacingCars(carNames);
        this.roundResult = new RoundResult();
    }

    private RacingCars createRacingCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new RacingCars(cars);
    }

    private void playOneRound() {
        this.racingCars = this.racingCars.moveCarAll();
        saveRoundResult();
    }

    private void saveRoundResult() {
        this.roundResult = this.roundResult.addResult(this.racingCars);
    }

    public void playAllRound() {
        for (int i = 0; i < this.gameCount; i++) {
            playOneRound();
        }
    }

    public List<String> findWinner() {
        return racingCars.findWinner();
    }

    public RoundResult getRoundResult() {
        return this.roundResult;
    }
}

package racingcar.car;

import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import racingcar.car.domain.winnerstrategy.WinnerStrategy;
import racingcar.car.ui.CarFormatter;
import racingcar.car.ui.DefaultCarFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주 게임 프로그램
 */
public class CarRacingGame {

    private Cars cars;
    private WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private CarFormatter formatter = new DefaultCarFormatter();


    public CarRacingGame(String carNames) {
        cars = new Cars(carNames);
    }

    /**
     * 자동차 경주 게임을 시작한다.
     *
     * @param playCount 게임 플레이 횟수
     */
    public void play(int playCount) {
        startRace(playCount);
        printWinners();
    }

    /**
     * 자동차 경주를 진행한다.
     *
     * @param count 게임 플레이 횟수
     */
    private void startRace(int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.move();
            cars.print(formatter);
        }
    }

    /**
     * 자동차 경주 게임의 우승자를 출력한다.
     */
    private void printWinners() {
        List<Car> winners = cars.getWinners(winnerStrategy);
        String raceResult = winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(", "));
        System.out.println(raceResult + "가 최종 우승했습니다.");
    }
}

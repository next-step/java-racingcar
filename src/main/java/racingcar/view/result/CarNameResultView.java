package racingcar.view.result;

import java.util.List;
import racingcar.domain.Car;
import racingcar.game.WinnerGetter;

import java.util.stream.Collectors;

public class CarNameResultView implements ResultView {

    private final WinnerGetter winnerGetter;

    public CarNameResultView(WinnerGetter winnerGetter){
        this.winnerGetter = winnerGetter;
    }

    @Override
    public void printRoundResult(List<Car> carList) {
        carList.forEach(
                car -> System.out.println(car.getName() + ":" + car.printPosition())
        );
    }

    @Override
    public void printWinner(List<Car> carList) {
        List<Car> winners = winnerGetter.getWinnerCars(carList);
        String winnerCarNames = winners.stream()
                                        .map(car -> car.getName())
                                        .collect(Collectors.joining(","));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
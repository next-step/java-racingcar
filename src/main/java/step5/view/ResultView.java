package step5.view;

import step5.domain.RacingCar;
import step5.domain.RacingGame;

import java.util.stream.IntStream;

public class ResultView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printResult(RacingGame racingGame) {
        racingGame.getCarList().forEach(this::printCar);
        System.out.println();
    }

    private void printCar(RacingCar car) {
        System.out.print(car.getCarName() + " : ");
        int position = car.getPosition();
        IntStream.range(0, position).forEach(i -> System.out.print("-"));
        System.out.println();
    }

    public void printWinner(RacingGame racingGame) {
        System.out.println(racingGame.getWinner() + "가 최종 우승했습니다.");
    }
}

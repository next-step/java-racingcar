package step5.racingcar3.view;

import java.util.Scanner;
import java.util.stream.Collectors;
import step5.racingcar3.domain.Car;
import step5.racingcar3.domain.RacingCarGameRound;

public class ResultView {

    private final static Scanner scanner = new Scanner(System.in);

    public void showCarResult(RacingCar car) {
        System.out.println(car.name() + " : " + "-".repeat(car.position()));
    }

    public void showRoundResult(RacingCarGameRound gameRound) {
        for (RacingCar car : gameRound.cars()) {
            showCarResult(car);
        }
        System.out.println();
    }

    public void showRoundWinners(RacingCarGameRound gameRound) {
        System.out.println(
            gameRound.winners().stream().map(RacingCar::name).collect(Collectors.joining(", ")) + "가 최종 우승했습니다.");
    }

}

package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ResultView {
    private static int MAX_POSITION = 0;

    public void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public void printRacingRound(List<RacingCar> racingCars) {

        for (RacingCar racingCar : racingCars) {
            String carMoveDistance = racingCar.name() + " : ";
            carMoveDistance += "-".repeat(racingCar.position());   // 자동차별 position 값 만큼 이동거리 표기

            setMaxPosition(racingCar);

            System.out.println(carMoveDistance);
        }

        System.out.println();
    }

    public void printGameWinner(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            winners.add(seekGameWinner(racingCar));
        }

        while (winners.remove("")) {
        }

        System.out.println(String.join(", ", winners).concat("가 최종 우승했습니다."));
    }

    public void setMaxPosition(RacingCar racingCar) {
        if (racingCar.position() >= MAX_POSITION) {
            MAX_POSITION = racingCar.position();
        }
    }

    public String seekGameWinner(RacingCar racingCar) {
        String winner = "";

        if (racingCar.position() == MAX_POSITION) {
            winner = racingCar.name();
        }

        return winner;
    }


}
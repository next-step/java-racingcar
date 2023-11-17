package racingcar.view;

import racingcar.model.CarName;
import racingcar.model.Position;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

import java.util.List;

public class ResultView {
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String LOCATION_MARK = "-";


    public static void printRoundResult(RacingGame game) {
        for (RacingCar car : game.cars()) {
            printLocationOfCar(car);
        }

        System.out.println();
    }

    public static void startPrint() {
        System.out.println();
        System.out.println(START_MESSAGE);
    }

    private static void printLocationOfCar(RacingCar car) {
        String result = car.name() + " : " + car.position().mark(LOCATION_MARK);
        System.out.println(result);
    }


    public static void printWinners(List<RacingCar> winners) {
        CarName[] winnersName = new CarName[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            winnersName[i] = winners.get(i).name();
        }
        String result = String.join(", ", winnersName.toString());

        result += WINNER_MESSAGE;
        System.out.println(result);
    }
}

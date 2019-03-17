package racinggame.View;

import racinggame.domain.Car;
import racinggame.domain.Racing;

import java.util.List;

import static racinggame.Controller.RacingGame.game;
import static utils.ConstantCollection.DELIMITER;

public class PrintRacing {

    // 결과를 출력하는 메서드
    public static void printRacing(Racing racing) {
        System.out.println("실행 결과");

        for(int i = 0; i < racing.getTryGame(); i++) {
            System.out.println(makeRacingForPrint(game(racing)));
        }

        List<String> winners = racing.getWinners();
        printWinner(winners);
    }

    public static StringBuilder makeRacingForPrint(Racing racing) {
        StringBuilder viewRacing = new StringBuilder();

        for(Car car : racing.getCars()) {
            viewRacing.append(car.getName() + " : ");
            viewRacing.append(makeCarMovementForPrint(car) + "\n");
        }

        return viewRacing;
    }

    public static StringBuilder makeCarMovementForPrint(Car car) {
        StringBuilder viewMoving = new StringBuilder();

        for(int i = 0; i < car.getCountMoving(); i++) {
            viewMoving.append("-");
        }

        return viewMoving;
    }

    public static void printWinner(List<String> winners) {
        System.out.print(setWinnerFormatForPrint(winners));
        System.out.println(" 가 최종 우승했습니다.");
    }

    private static String setWinnerFormatForPrint(List<String> winners) {
        StringBuilder winnersForPrint = new StringBuilder();

        for(String winner : winners) {
            winnersForPrint.append(winner).append(DELIMITER);
        }

        return winnersForPrint.substring(0, winnersForPrint.length() - 1);
    }
}

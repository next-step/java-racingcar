package racingGame.view;

import racingGame.Car;
import racingGame.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String TIRE_MARK = "-";
    private static final String WINNING_SENTENCE = "가 최종 우승했습니다.";

    public static void printRacingResult(Cars cars) {
        printTitle();
        StringBuilder sb = new StringBuilder();
        combineResult(cars, sb);
        System.out.println(sb);
        System.out.println(joinWinners(cars));
    }

    private static String joinWinners(Cars cars) {
        return String.join(", ", cars.getWinners()).concat(WINNING_SENTENCE);
    }

    private static void combineResult(Cars cars, StringBuilder sb) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            sb.append(cars.getCars().get(i).getCarName());
            sb.append(" ");
            sb.append(":");
            sb.append(" ");
            sb.append(cars.getCars().get(i).createTrace(TIRE_MARK));
            sb.append("\n");
        }
    }


    private static void printTitle() {
        System.out.println("살행결과");
    }


}

package study.step5.view;

import java.util.List;
import java.util.StringJoiner;

import study.step5.domain.Car;
import study.step5.domain.Position;

public class ResultView {
    private final static String MESSAGE_RACING_START = "자동차 경주를 시작합니다.";
    private final static String MESSAGE_RACING_ROUND = "라운드";
    private final static String MESSAGE_RACING_WINNER = "가 최종 우승하였습니다.";
    private final static String PRINT_TOKEN = "-";

    public static void printRacingStart() {
        System.out.println(MESSAGE_RACING_START);
    }

    public static void printRacingRound(int round) {
        System.out.println("\n" + round + MESSAGE_RACING_ROUND);
    }

    public static void printRacingResult(List<Car> carList) {
        carList.stream()
            .forEach(car -> {
                System.out.println(car.getName().toString() + " : " + convertPositionToPrintToken(car.getPosition(), PRINT_TOKEN));
            });
    }

    private static String convertPositionToPrintToken(Position position, String printToken) {
        return new String(new char[position.getPosition()]).replace("\0", printToken);
    }

    public static void printRacingWinner(List<Car> winnerNames) {
        StringJoiner winner = new StringJoiner(",");
        winnerNames.forEach(car -> winner.add(car.getName().toString()));
        System.out.println("\n" + winner.toString() + MESSAGE_RACING_WINNER);
    }
}

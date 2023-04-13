package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.RacingCar;

public class OutputView {
    private static final String POSITION_SEPARATOR = "-";

    private OutputView() {
    }

    public static void printCarsPositionStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printCarsNameAndPositionStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printCarNameAndPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자: " + winnerNames);
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SEPARATOR);
        }
        System.out.println();
    }

    private static void printCarNameAndPosition(RacingCar car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SEPARATOR);
        }
        System.out.println();
    }
}

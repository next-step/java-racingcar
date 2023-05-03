package racing.view;

import racing.dto.RaceResponseDto;
import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class ResultView {

    public static void printResult(RaceResponseDto responseDto) {
        printResultInfoMessage();
        printAllRoundResult(responseDto.getResults());
        printRoundWinners(responseDto.getWinners());
    }

    private static void printAllRoundResult(List<Cars> results) {

        for (Cars roundResult : results) {
            printRoundResult(roundResult.getCars());
            System.out.println();
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printName(car);
            printDash(car);
            System.out.println();
        }
    }

    private static void printRoundWinners(List<Car> winners) {

        int count = winners.size();

        for (Car winner : winners) {
            printWinnersName(winner, --count);
        }

        printWinnersMessageSuffix();
    }

    private static void printResultInfoMessage() {
        System.out.println("실행 결과");
    }

    private static void printDash(Car car) {
        int num = car.getPosition();
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    private static void printName(Car car) {
        String name = car.getName();
        System.out.print(name + " : ");
    }

    private static void printWinnersName(Car winner, int count) {
        System.out.printf(winner.getName());

        if (count != 0) {
            System.out.printf(", ");
        }
    }

    private static void printWinnersMessageSuffix() {
        System.out.printf("가 우승했습니다.");
    }

}

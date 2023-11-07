package carracing.ui;

import carracing.dto.CarRaceResponse;

import java.util.List;

public class OutputView {

    public static void output(CarRaceResponse response) {
        printHeader();
        newLine();
        response.getCarResponses().forEach(carsResponse -> {
            System.out.println(carsResponse.getCarsInfo());
        });
        printWinner(response.getWinnerNames());
    }

    private static void printHeader() {
        System.out.println("실행 경과");
    }

    private static void newLine() {
        System.out.println("\n");
    }

    private static void printWinner(List<String> winnerNames) {
        System.out.printf("%s 가 최종 우승했습니다.", String.join(",", winnerNames));
    }
}

package racingcar.view;

import racingcar.dto.Board;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String CAR_POSITION_DISPLAY = "-";
    private static final String COMMA = ",";

    public static void printResult(Board board) {
        List<List<Integer>> allRecords = board.getAllRecords();
        List<List<String>> allRecordsCarNames = board.getAllRecordsCarsNames();

        for (int i = 0; i < allRecords.size(); i++) {
            printBoard(allRecordsCarNames.get(i), allRecords.get(i));
            System.out.println();
        }

        printWinners(board);

    }

    private static void printWinners(Board board) {
        List<String> winners = board.getWinnerCarsNames();

        System.out.print(winners.stream()
                .collect(Collectors.joining(COMMA)));
        System.out.print(" 가 최종 우승했습니다.");
    }

    private static void printBoard(List<String> carsNames, List<Integer> carsPositions) {

        for (int i = 0; i < carsNames.size(); i++) {
            appendCarPosition(carsNames.get(i), carsPositions.get(i));
        }

    }

    private static void appendCarPosition(String carsNames, Integer carPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            sb.append(CAR_POSITION_DISPLAY);
        }
        System.out.println(carsNames + " : " + sb);
    }
}

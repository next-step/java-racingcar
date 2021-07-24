package racingcar.view;

import racingcar.dto.Board;

import java.util.List;

public class ResultView {

    private static final String CAR_POSITION = "-";

    public static void printResult(Board board) {
        List<List<Integer>> allRecords = board.getAllRecords();

        for (int i = 0; i < allRecords.size(); i++) {
            print(allRecords.get(i));
            System.out.println();
        }
    }

    private static void print(List<Integer> carsPositions) {
        carsPositions.forEach(carPosition -> {
            appendCarPosition(carPosition);
        });
    }

    private static void appendCarPosition(Integer carPosition){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            sb.append(CAR_POSITION);
        }
        System.out.println(sb);
    }
}

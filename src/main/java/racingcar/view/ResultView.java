package racingcar.view;

import racingcar.model.Board;

import java.util.List;

public class ResultView {

    private final Board board;
    private static final String CAR_POSITION = "-";

    public ResultView(Board board) {
        this.board = board;
    }

    public void printResult() {
        List<List<Integer>> allRecords = board.getAllRecords();

        for (int i = 0; i < allRecords.size(); i++) {
            print(allRecords.get(i));
            System.out.println();
        }
    }

    private void print(List<Integer> carsPositions) {
        carsPositions.stream().forEach(carPosition -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < carPosition; i++) {
                sb.append(CAR_POSITION);
            }
            System.out.println(sb);
        });
    }
}

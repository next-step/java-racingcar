package racing.view;

import java.util.List;

public class ResultView {
    private final String message;

    public ResultView(String message) {
        this.message = message;
        init();
    }

    private void init() {
        System.out.println(message);
    }

    public void print(List<List<Integer>> allRoundCarsPositionList) {
        for (List<Integer> positions : allRoundCarsPositionList) {
            printRoundPosition(positions);

            System.out.println();
        }
    }

    private void printRoundPosition(List<Integer> positions) {
        for (Integer position : positions) {
            drawCarPosition(position);
        }
    }

    private void drawCarPosition(int position) {
        StringBuilder paper = new StringBuilder();

        for (int i = 0; i < position; i++) {
            paper.append("-");
        }

        System.out.println(paper.toString());
    }
}

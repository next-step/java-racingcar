package racingcar.view;

import java.util.List;

public class OutputView {

    public void printTitle() {
        System.out.println("\n실행결과");
    }
    public void printRaceResult(List<Integer> raceResults) {
        for (int position : raceResults) {
            draw(position);
        }
        System.out.println();

    }

    private void draw(int position) {
        for (int i = 0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

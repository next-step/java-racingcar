package racingcar.view;

import racingcar.MoveResults;

public class ResultView {

    private ResultView() {
    }

    public static void print(MoveResults moveResults) {
        int size = moveResults.size();

        for (int i = 0; i < size; i++) {
            print(moveResults.get(i));
        }
    }

    private static void print(int[] result) {
        for (int position : result) {
            System.out.print(":");
            print(position);
        }

        System.out.println();
    }

    private static void print(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}

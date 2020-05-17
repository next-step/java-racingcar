package racingcar.view;

import racingcar.RacingResult;

public class ResultView {

    private ResultView() {
    }

    public static void print(RacingResult racingResult) {
        int size = racingResult.size();

        for (int i = 0; i < size; i++) {
            print(racingResult.get(i));
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

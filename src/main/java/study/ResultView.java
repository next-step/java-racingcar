package study;

public class ResultView {
    void displayResult(RacingCarGame game) {
        for (int k = 0; k < game.getRounds(); k++) {
            for (int i = 0; i < game.getCars(); i++) {
                for (int j = 0; j <= k; j++) {
                    if (game.getRacingCarByIndex(i).getDistanceByIndex(j)) {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

package car.entity;

public class ResultView {
    public static void printAllGame(GameResult gameResult) {
        gameResult.getAllResult().forEach(racingRound -> {
            printOneRound(racingRound);
            System.out.println();
        });
    }

    private static void printOneRound(RacingRound racingRound) {
        racingRound.getRound().forEach(aCar -> {
            printOneRound(aCar);
            System.out.println();
        });
    }

    private static void printOneRound(Car car) {
        int i = 0;

        while ( i < car.getMovingCount() ) {
            System.out.print("-");
            i++;
        }
    }
}

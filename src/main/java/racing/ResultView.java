package racing;

public class ResultView {
    public static void watchRace(RacingGame racingGame){
        System.out.println("실행결과");
        for (int i = 0 ; i < racingGame.getTime(); i++){
            watchTrace(racingGame.move());
        }
    }

    private static void watchTrace(int[] carPositions) {
        for(int j =0; j < carPositions.length; j++){
            drawTrace(carPositions[j]);
        }
        System.out.println();
    }

    private static void drawTrace(int carPosition) {
        for (int k = 0; k < carPosition; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

}

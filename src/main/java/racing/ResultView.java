package racing;

public class ResultView {
    RacingGame racingGame;

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void watchRace(){
        for (int i = 0 ; i < racingGame.getTime(); i++){
            watchTrace(racingGame.move());
        }
    }

    private void watchTrace(int[] carPositions) {
        for(int j =0; j < carPositions.length; j++){
            drawTrace(carPositions[j]);
        }
        System.out.println();
    }

    private void drawTrace(int carPosition) {
        for (int k = 0; k < carPosition; k++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

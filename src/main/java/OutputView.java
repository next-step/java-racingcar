public class OutputView {

    public void resultView(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getCarPosition().length; i++) {
            System.out.print(racingGame.getCarNames()[i] + " : ");
            makeDash(racingGame, i);
            System.out.println("");
        }
    }

    public void makeDash(RacingGame racingGame, int idx) {
        for (int j = 0; j < racingGame.getCarPosition()[idx]; j++) {
            System.out.print("-");
        }
    }

}

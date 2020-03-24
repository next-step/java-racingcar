public class OutputView {

    public void resultView(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getCars().length; i++) {
            System.out.print(racingGame.getCars()[i].getName() + " : ");
            makeDash(racingGame, i);
            System.out.println("");
        }
    }

    public void makeDash(RacingGame racingGame, int idx) {
        for (int j = 0; j < racingGame.getCars()[idx].getPosition(); j++) {
            System.out.print("-");
        }
    }

}

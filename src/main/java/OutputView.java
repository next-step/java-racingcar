public class OutputView {

    public void resultView(RacingGame game) {
        for (int i = 0; i < game.getCarPosition().length; i++) {
            for (int j = 0; j < game.getCarPosition()[i]; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }

    }
}

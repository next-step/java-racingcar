package racingcarwinner;

public class GameController {

    private static Game game;

    private GameController(){}

    public static void createGame(int roundCount){
        game = new Game(roundCount);
    }

    public static Game getGame(){
        return game;
    }

    public static void playGame(){
        InputView.inputCarsName();
        InputView.inputRoundCount();

        ResultView.viewResultMessage();

        for (int i = 0; i < game.getRoundCount(); i++) {
            playRound();
        }

        WinnerPicker.pickWinner();
        ResultView.viewWinner();
    }

    public static void playRound(){
        for (int i = 0; i < Cars.getCarsCount(); i++) {
            game.randomMove(Cars.getCar(i));
            ResultView.viewCarsTravelDistance(Cars.getCar(i));
        }
        System.out.println();
    }


}

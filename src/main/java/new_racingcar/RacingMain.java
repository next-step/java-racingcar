package new_racingcar;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int playerCount = inputView.setPlayer();
        int turnCount = inputView.setTurn();

        GrandPrix grandPrix = new GrandPrix();
        grandPrix.start(playerCount, turnCount);
    }
}

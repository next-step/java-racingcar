package racingcar;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int playerCount = inputView.setInputPlayerCount();
        int labCount = inputView.setInputLastLabCount();

        GrandPrix grandPrix = new GrandPrix();
        grandPrix.grandPrixStart(playerCount, labCount);
    }
}

package racing.view;

import racing.TheGame;

public class OutputView {

    public String winnerCar() {

        System.out.println("실행결과");
        int winnerPosition = TheGame.racing();

        String winner = TheGame.getWinner(winnerPosition);
        return winner;
    }
}

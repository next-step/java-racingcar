package racing.view;

import racing.domain.GetWinner;
import racing.domain.Racing;

public class OutputView {

    public String winnerCar() {

        System.out.println("실행결과");
        int winnerPosition = Racing.racing();

        String winner = GetWinner.getWinner(winnerPosition);
        return winner;
    }
}

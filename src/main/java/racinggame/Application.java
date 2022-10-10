package racinggame;
import racinggame.domain.Referee;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();
        referee.startGame();
    }
}

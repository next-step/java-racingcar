package racinggame;

import java.util.List;
import racinggame.domain.GameInit;
import racinggame.domain.Racing;
import racinggame.domain.Winner;

public class Application {

    public static void main(String[] args) {
        GameInit gameInit = new GameInit();
        List<String> carNames = gameInit.inputCarName();
        int playGameNumber = gameInit.inputTryNumber();

        Racing game = new Racing();
        game.race(carNames, playGameNumber);
        System.out.println(game.getResult());
        Winner.print(game.getCarInfo());
    }

}

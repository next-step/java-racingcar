package rcgame;

import rcgame.domain.RcGame;
import rcgame.util.NumberGenerator;

import static rcgame.ui.ConsoleUI.*;

public class Main {
    public static void main(String[] args) {

        RcGame rcGame = new RcGame(getRcGameRequest());

        printProgressNotice();

        while(rcGame.isOnGoing()) {
            printRcCarPositions(rcGame.race());
        }

        printWinnerNotice(rcGame.identifyWinner());
    }
}

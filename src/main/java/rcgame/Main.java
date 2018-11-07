package rcgame;

import rcgame.domain.RcGame;
import rcgame.util.NumberGenerator;
import rcgame.util.RandomNumberGenerator;

import static rcgame.ui.ConsoleUI.*;

public class Main {
    public static void main(String[] args) {

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RcGame rcGame = new RcGame(getRcGameRequest());

        printProgressNotice();

        while(rcGame.isOnGoing()) {
            printRcCarPositions(rcGame.race(numberGenerator));
        }

        printWinnerNotice(rcGame.identifyWinner());
    }
}

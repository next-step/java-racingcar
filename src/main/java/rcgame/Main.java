package rcgame;

import rcgame.domain.RcGame;
import rcgame.dto.RcGameRequestDto;
import rcgame.ui.ConsoleUI;

import java.util.List;

import static rcgame.ui.ConsoleUI.getRcGameRequest;
import static rcgame.ui.ConsoleUI.printResultNotice;

public class Main {
    public static void main(String[] args) {

        ConsoleUI consoleUI = new ConsoleUI();
        RcGameRequestDto requestDto = getRcGameRequest();

        RcGame rcGame = new RcGame(requestDto);

        printResultNotice();

        while(rcGame.isOnGoing()) {
            List<Integer> positions = rcGame.race();
            consoleUI.printRcCarPositions(positions);
        }


    }
}

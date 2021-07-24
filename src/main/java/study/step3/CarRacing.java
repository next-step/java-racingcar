package study.step3;

import study.step3.controller.ConsoleInput;
import study.step3.domain.CarManager;
import study.step3.domain.RaceManager;
import study.step3.domain.RoundManager;
import study.step3.view.ConsoleOutput;

public class CarRacing {

    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_SYMBOL = "-";

    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        RaceManager raceManager = new RaceManager(new CarManager(), new RoundManager());
        ConsoleOutput consoleOutput = new ConsoleOutput();

        int carNumber = consoleInput.getNumber(CAR_QUESTION);
        int roundNumber = consoleInput.getNumber(ROUND_QUESTION);
        consoleOutput.printRaceRecords(raceManager.manageRace(carNumber, roundNumber), CAR_SYMBOL);
    }

}

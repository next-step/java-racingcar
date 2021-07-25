package study.step3;

import study.step3.controller.RaceController;
import study.step3.service.RaceService;
import study.step3.view.ConsoleInput;
import study.step3.view.ConsoleOutput;

public class CarRacing {

    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_SYMBOL = "-";

    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        RaceController raceController = new RaceController(new RaceService());
        ConsoleOutput consoleOutput = new ConsoleOutput();

        int carNumber = consoleInput.getNumber(CAR_QUESTION);
        int roundNumber = consoleInput.getNumber(ROUND_QUESTION);
        consoleOutput.printRaceRecords(raceController.play(carNumber, roundNumber), CAR_SYMBOL);
    }

}

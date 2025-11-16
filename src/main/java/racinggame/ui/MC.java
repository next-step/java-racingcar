package racinggame.ui;

import static racinggame.ui.InputView.inputInt;
import static racinggame.ui.InputView.inputString;
import static racinggame.ui.ResultView.printCarNamesQuestion;
import static racinggame.ui.ResultView.printCarPosition;
import static racinggame.ui.ResultView.printTryCountQuestion;

import racinggame.model.car.Car;
import racinggame.model.winner.Winners;

public class MC {

    public static UserInput getUserInput() {
        return new UserInput(
                askCarNamesToUser(),
                askTryCountToUser()
        );
    }

    public static String askCarNamesToUser() {
        printCarNamesQuestion();

        return inputString();
    }

    public static int askTryCountToUser() {
        printTryCountQuestion();

        return inputInt();
    }

    public static void printGameStates(Car car) {
        printCarPosition(car.getStateMessage());
    }

    public static void printLineBreaker() {
        ResultView.printLineBreaker();
    }

    public static void printEndMessage(Winners winners) {
        ResultView.printEndMessage(winners.getResultMessage());
    }
}

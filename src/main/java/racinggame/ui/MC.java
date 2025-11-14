package racinggame.ui;

import static racinggame.ui.InputView.inputInt;
import static racinggame.ui.InputView.inputString;
import static racinggame.ui.ResultView.printCarNamesQuestion;
import static racinggame.ui.ResultView.printCarPosition;
import static racinggame.ui.ResultView.printLineBreaker;
import static racinggame.ui.ResultView.printTryCountQuestion;

import racinggame.car.Car;
import racinggame.car.Cars;

// UI 의 기능의 추상화단계를 높히고
// UI 클래스와 비즈니스 클래스의 결합도를 낮추기 위한 클래스
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

    public static void printGameStates(Cars cars) {

        printLineBreaker();
    }

}

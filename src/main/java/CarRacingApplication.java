import static view.ResultView.createResultView;

import domain.Cars;
import domain.UserInput;
import view.InputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        run(getInput());
    }

    private static void run(UserInput userInput) {
        int attemptCount = userInput.getAttemptCount();
        createResultView(new Cars(userInput), attemptCount);
    }

    private static UserInput getInput() {
        return new InputView()
                .getUserInputForRace();
    }
}

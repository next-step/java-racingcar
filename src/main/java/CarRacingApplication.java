import static core.RacingGameFactory.makeARace;

import domain.UserInput;
import view.InputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        run(getInput());
    }

    private static void run(UserInput userInput) {
        makeARace(userInput);
    }

    private static UserInput getInput() {
        return new InputView()
                .getUserInputForRace();
    }
}

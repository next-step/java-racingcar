import racingcar.InputView;
import racingcar.ResultView;
import racingcar.User;
import racingcar.UserArguments;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        UserArguments userArgs = inputView.createUserArgument();
        User user = User.createUser(userArgs);
        ResultView resultView = new ResultView();

        while (user.hasNext()) {
            user.moveCars();
            user.nextStep();

            resultView.printAllCars(user.getCars());
        }
    }
}

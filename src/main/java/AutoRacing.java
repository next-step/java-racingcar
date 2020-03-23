import domain.Car;
import domain.GameRole;
import ui.InputView;
import ui.ResultView;
import util.CarFactory;

import java.util.List;
import java.util.Random;

public class AutoRacing {

    private GameRole gameRole;
    private List<Car> cars;

    public AutoRacing(GameRole gameRole) {
        this.gameRole = gameRole;
        this.cars = CarFactory.createCars(this.gameRole.getNames());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameRole gameRole = inputView.getGameRole();
        AutoRacing autoRacing = new AutoRacing(gameRole);
        autoRacing.playGame();
        autoRacing.printResult();
    }

    public void playGame() {
        Random random = new Random();
        int numberOfAttempts = gameRole.getNumberOfAttempts();
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                int condition = random.nextInt(10);
                car.move(condition);
            }
        }
    }

    private void printResult() {
        ResultView resultView = new ResultView();
        resultView.printResult(this.cars, this.gameRole.getNumberOfAttempts());
    }


}

package mission1.racing;

import mission1.racing.model.Car;
import mission1.racing.view.RacingGameInputView;
import mission1.racing.view.RacingGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private int maxPosition = 0;

    private Car[] cars;
    private List<String> winners = new ArrayList<>();
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameOutputView outputView = new RacingGameOutputView();

    public void announceWinners() {
        setGame();

        for (int i = 0; i < time; i++) startGame();
        for (Car car: cars) getWinners(car);

        outputView.winnerView(winners.toArray(new String[winners.size()]));
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    private void getWinners(Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car.getName());
        }
    }

    private void startGame() {
        for (Car car : cars) {
            car.go();
            outputView.resultView(car.getName(), car.getCarPositions());
            checkMaxPosition(car.getCarPositions());
        }

        System.out.println();
    }

    public void checkMaxPosition(int p) {
        if (maxPosition < p) {
            maxPosition = p;
        }
    }

    private void setGame() {
        String inputName = inputView.inputCarsNameView();
        String[] names = inputName.split(",");
        time = inputView.inputNumOfCarsView();

        cars = new Car[names.length];

        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }
}

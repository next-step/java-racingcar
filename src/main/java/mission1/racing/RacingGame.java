package mission1.racing;

import mission1.racing.model.Car;
import mission1.racing.view.RacingGameInputView;
import mission1.racing.view.RacingGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;

    private Car[] cars;
    private List<String> winners = new ArrayList<>();

    public void announceWinners() {
        setGame();

        for (int i = 0; i < time; i++) {
            startGame();
        }

        RacingGameOutputView.winnerView(getWinners());
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars)  {
            maxPosition = checkMaxPosition(maxPosition, car.getCarPositions());
        }
        return maxPosition;
    }

    public int checkMaxPosition(int max, int position) {
        return Math.max(max, position);
    }

    public List<String> getWinnersArrayList() {
        return winners;
    }

    private String[] getWinners() {
        int maxPosition = getMaxPosition();
        for (Car car: cars) {
            addWinner(car, maxPosition);
        }

        return winners.toArray(new String[winners.size()]);
    }

    public void addWinner(Car car, int maxPosition) {
        if (car.isWinner(maxPosition)) {
            winners.add(car.getName());
        }
    }

    private void startGame() {
        for (Car car : cars) {
            car.go();
            RacingGameOutputView.resultView(car.getName(), car.getCarPositions());
        }

        System.out.println();
    }

    private void setGame() {
        String inputName = RacingGameInputView.inputCarsNameView();
        String[] names = inputName.split(",");
        time = RacingGameInputView.inputNumOfCarsView();

        cars = new Car[names.length];

        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }
}
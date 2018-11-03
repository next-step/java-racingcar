package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private InputView inputView;
    private ResultView resultView;

    public RacingGame() {
        cars = new ArrayList<>();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void move() {
        setCars();

        for (int i = 0; i < inputView.getTryNumber(); i++) {
            movingCarByValue();
            resultView.showResult(cars);
        }
    }

    private void setCars() {
        for(int i = 0; i < inputView.getCarNumber(); i++) {
            cars.add(new Car());
        }
    }

    private void movingCarByValue() {
        for (Car car : cars) {
            setNewPosition(car);
        }
    }

    private void setNewPosition(Car car) {
        int randomValue = new Random().nextInt(10);
        if (randomValue >= 4) {
            car.addPosition();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.move();
    }

    public List<Car> getCars() {
        return cars;
    }
}

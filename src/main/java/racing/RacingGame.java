package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private String carNames;
    private int carNumber;
    private int tryNumber;
    private static final int MAX_BOUND = 10;

    public RacingGame() {
        cars = new ArrayList<>();
        carNames = InputView.getCarNames();
        tryNumber = InputView.getTryNumber();
    }

    public void startGame() {
        //차 세팅
        setCars();

        //경기 시작
        doTracing();

        //결과 출력
        ResultView.showResult(cars, tryNumber);

        //승자 출력
        ResultView.showWinner(cars);
    }

    private void doTracing() {
        for (int i = 0; i < tryNumber; i++) {
            movingCarByValue();
        }
    }

    private void setCars() {
        String[] names = carNames.split(",");
        carNumber = names.length;
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private void movingCarByValue() {
        for (Car car : cars) {
            setNewPosition(car);
        }
    }

    private void setNewPosition(Car car) {
        int randomValue = new Random().nextInt(MAX_BOUND);
        car.addPosition(randomValue);
        car.record(car.getPosition());
    }

    public List<Car> getCars() {
        return cars;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.startGame();
    }
}

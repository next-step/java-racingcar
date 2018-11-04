package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private int tryNumber;
    private int carNumber;
    private static final int MAX_BOUND = 10;



    public RacingGame() {
        cars = new ArrayList<>();
        carNumber = InputView.getCarNumber();
        tryNumber = InputView.getTryNumber();
    }

    public void move() {
        //차 세팅
        setCars();

        //경기 시작
        doTracing();

        //결과 출력
        ResultView.showResult(cars, tryNumber);
    }

    private void doTracing() {
        for (int i = 0; i < tryNumber; i++) {
            movingCarByValue();
        }
    }

    private void setCars() {
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car());
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
        racingGame.move();
    }
}

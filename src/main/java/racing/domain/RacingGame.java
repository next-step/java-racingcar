package racing.domain;

import racing.utils.ConvertString;
import racing.utils.RandomNumber;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String inputCarNames = Input.carNames();
        System.out.println("시도할 횟수는 몇회인가요?");
        int count = Input.gameCount();
        System.out.println("\n" + "실행 결과");
        String[] carNames = ConvertString.splitString(inputCarNames);
        List<Car> cars = makeCars(carNames);
        repeatMoveCount(cars, count);
        Winner winner = new Winner();
        Output.win(winner.findWinner(cars));
    }

    private void repeatMoveCount(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            moveCountChange(cars);
            Output.printCarDistance(cars);
        }
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCountChange(List<Car> cars) {
        int carsSize = cars.size();
        for (int i = 0; i < carsSize; i++) {
            cars.get(i).move(RandomNumber.makeRandomNumber());
        }
    }
}
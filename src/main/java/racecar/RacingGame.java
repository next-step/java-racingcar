package racecar;

import java.util.List;
import java.util.Random;

public class RacingGame {


    public static void main(String[] args) {
        //입력
        String[] carName = InputView.askCarNames();
        int repeatCount = InputView.askRepeatCount();

        //게임 준비
        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.ready(carName);

        //게임 실행
        for (int i = 0; i < repeatCount; i++) {
            racingGame.start(carList);
        }

        //우승자 발표
        racingGame.announceWinner();

    }

    public List<Car> ready(String[] carName) {
        List<Car> carList = Car.ready(carName);
        return carList;
    }

    public void start(List<Car> carList) {
        Random random = new Random();
        for (Car car : carList) {
            car.move(random);
            ResultView.print(car);
        }
        System.out.println();
    }

    public void announceWinner() {
        int max = Car.getMaxPosition();
        List<String> winners = Car.selectWinner(max);
        ResultView.printWinner(winners);
    }

}

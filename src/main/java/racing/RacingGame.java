package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int round;
    private List<Car> carList;

    public RacingGame(int carCount, int round) {
        initGame(carCount, round);
    }

    public void playGame() {
        ResultView resultView = new ResultView("실행 결과");

        for (int i = 0; i < round; i++) {
            playRound();
            resultView.print(carList);
        }
    }

    private void initGame(int carCount, int round) {
        this.round = round;
        settingCar(carCount);
    }

    private void settingCar(int count) {
        carList = new ArrayList<>();

        for (int i = 0 ; i < count ; i++) {
            carList.add(new Car());
        }
    }

    private void playRound() {
        for (Car car : carList) {
            car.move();
        }
    }

}

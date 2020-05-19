package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> carList;

    public void initGame() {
        InputView firstQuestion = new InputView("자동차 대수는 몇 대 인가요?");
        int carCount = firstQuestion.play();

        settingCar(carCount);

        InputView secondQuestion = new InputView("시도할 회수는 몇 회 인가요?");
        this.time = secondQuestion.play();
    }

    public void playGame() {
        ResultView resultView = new ResultView("실행 결과");
        resultView.init();

        for (int i = 0; i < time; i++) {
            playRound();
            resultView.print(carList);
        }
    }

    private void settingCar(int count) {
        carList = new ArrayList<>();

        for (int i = 0 ; i < count ; i++) {
            carList.add(new Car());
        }
    }

    private void playRound() {
        for (Car car : carList) {
            car.drive();
        }
    }

}

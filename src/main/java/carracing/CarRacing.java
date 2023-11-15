package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public void StartRacingGame(){

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<Car> cars = new ArrayList<Car>();
        int carsValue = inputView.getInputValue("자동차 대수는 몇 대 인가요?");
        for (int i = 0; i < carsValue; i++) {
            cars.add(new Car());
        }

        int moveCount = inputView.getInputValue("시도할 회수는 몇 회 인가요?");

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move(new Random().nextInt(10));
                resultView.showResultComment(car.getPosition());
            }
        }
    }
}

package racingcarGame;

import racingcarGame.client.ResultView;
import racingcarGame.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcarGame.client.InputView.scanCarCount;
import static racingcarGame.client.InputView.scanPlayCount;
import static racingcarGame.client.ResultView.showResult;

/**
 * 컨트롤 - 조종
 * 모델을 어쩌구저쩌구
 * 뷰에다가 표시해
 * <p>
 * 자동차 게임을 개최한다. (컨)
 * 자동차(모델)가 주사위를 던지고 당첨되면 1칸 앞으로! (모델이 일을 한다 - oop)
 * n번 시행 - 컨
 * 화면에 표시. - 컨트롤러가 모델을 뷰에다가 던져서 표시하도록
 */
public class RacingGame {
    public static void main(String[] args) {
        List<Car> cars = readyCars();

        int playCount = scanPlayCount();

        ResultView.showGameResultTitle();

        for (var i = 0; i < playCount; i++) {
            play(cars);
            showResult(cars);
        }
    }

    private static void play(List<Car> cars) {
       cars.forEach(car -> {
            int chosenNumber = car.pickRandomlyNumber();
            car.move(chosenNumber);
        });
    }

    private static List<Car> readyCars() {
        List<Car> cars = new ArrayList<>();

        int carCount = scanCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }

        return cars;
    }
}

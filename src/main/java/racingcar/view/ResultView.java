package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

public class ResultView {

    public void showRaceResult(List<Car> cars) {
        for (Car car : cars) {
            showResult(car);
        }
        System.out.println();
    }

    private void showResult(Car car) {
        System.out.print(car.getCarName() + ": ");
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinner(List<Car> cars) {
        RacingGame racingGame = new RacingGame();
        List<Car> winners = racingGame.getWinners(cars);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getCarName());
            builder.append(", ");
        }

        String result = builder.toString();
        int lastIndex = result.lastIndexOf(",");
        result = result.substring(0, lastIndex);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}

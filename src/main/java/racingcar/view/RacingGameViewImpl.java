package racingcar.view;

import racingcar.domain.Car;
import racingcar.resources.RacingGameResource;
import racingcar.utils.StringDecoration;

import java.util.List;
import java.util.Scanner;

public class RacingGameViewImpl implements RacingGameView {
    private final Scanner scanner = new Scanner(System.in);
    private final StringDecoration stringDecoration = new StringDecoration();

    @Override
    public String[] inputCarNames() {
        System.out.println(RacingGameResource.INPUT_CAR_NAME_HINT);
        String inputLine = scanner.nextLine();
        String[] carNames = stringDecoration.splitCarName(inputLine);

        return carNames;
    }

    @Override
    public int inputPlayCount() {
        System.out.println(RacingGameResource.INPUT_PLAY_COUNT_HINT);
        int playCount = scanner.nextInt();
        System.out.println();
        return playCount;
    }

    @Override
    public void printWinner(List<Car> winners) {
        String winnerResult = stringDecoration.decorateWinner(winners);
        System.out.println(RacingGameResource.FINAL_WINNER_DECORATION + winnerResult);
    }

    @Override
    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            String carPrintResult = stringDecoration.decorateCarPosition(car);
            System.out.println(carPrintResult);
        }
        System.out.println();
    }
}
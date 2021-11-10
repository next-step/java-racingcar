package racingcar.step5.view;

import racingcar.step5.domain.Car;
import racingcar.step5.domain.Cars;
import racingcar.step5.domain.RacingGame;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.step5.message.ViewMessage.*;

public class ResultView {

    public void executeMessage() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public void printResult(Cars cars) {
        cars.getCars()
                .forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printWinners(RacingGame racingGame) {
        StringBuilder builder = new StringBuilder();
        List<Car> winners = racingGame.findWinners();
        int size = winners.size();
        IntStream.range(0, size)
                .forEach(i -> {
                    builder.append(winners.get(i).getName().toString());
                    appendComma(builder, size, i);
                });
        builder.append(WINNERS_RESULT_MESSAGE);
        System.out.println(builder);
    }

    private void appendComma(StringBuilder builder, int size, int index) {
        if (index != size - 1) {
            builder.append(WINNER_DELIMITER);
        }
    }

}

package racingcar.step5.view;

import racingcar.step5.domain.Car;
import racingcar.step5.domain.Cars;
import racingcar.step5.domain.RacingGame;

import java.util.stream.Collectors;

import static racingcar.step5.message.ViewMessage.*;

public class ResultView {

    public void executeMessage() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public void printRacing(Cars cars) {
        StringBuilder builder = new StringBuilder();
        cars.getCars()
                .forEach(car -> appendSign(builder, car));
        System.out.println(builder);
    }

    public void printWinners(RacingGame racingGame) {
        String winners =
                racingGame.findWinners().stream()
                .map(car -> car.getName().getName())
                .collect(Collectors.joining(WINNER_DELIMITER))
                + WINNERS_RESULT_MESSAGE;
        System.out.println(winners);
    }

    private void appendSign(StringBuilder builder, Car car) {
        builder.append(car.getName().getName());
        builder.append(NAME_DELIMITER);
        for (int i = 0; i < car.getPosition().getPosition(); i++) {
            builder.append(POSITION_SIGN);
        }
        builder.append('\n');
    }

}

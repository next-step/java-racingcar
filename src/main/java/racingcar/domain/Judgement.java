package racingcar.domain;

import static racingcar.common.info.RacingGameInfo.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import racingcar.common.info.RacingGameInfo;

public class Judgement {

    private static final String DELIMITER = " : ";
    private static final String DASH_SIGH = "-";
    private static final String NEW_LINE = "\n";
    private static final int NUMBER_ZERO = 0;
    private final BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public void judge(final List<Car> cars) {
        int max = maxDriveLength(cars);

        try {
            log.write(WINNER_IS);
            log.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        for (Car car : cars) {
            printWinner(max, car);
        }
    }

    public void carsStatement(final List<Car> cars) {
        for (Car car : cars) {
            carStatementMessage(car);
        }
    }

    public void carStatementMessage(Car car) {
        try {
            log.write(car.getName() + DELIMITER + carPosition(car) + NEW_LINE);
            log.flush();
        } catch (IOException exception) {
            exception.getMessage();
        }
    }

    private void printWinner(final int max, final Car car) {

        try {
            log.write(car.toString(max));
            log.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private int maxDriveLength(List<Car> cars) {
        return cars.stream().map(car -> car.getStep())
            .mapToInt(length -> Integer.valueOf(length))
            .max()
            .getAsInt();
    }

    private String carPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = NUMBER_ZERO; i < car.getStep(); i++) {
            stringBuilder.append(DASH_SIGH);
        }

        return stringBuilder.toString();
    }
}

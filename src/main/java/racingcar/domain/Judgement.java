package racingcar.domain;

import static racingcar.common.info.RacingGameInfo.*;

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
    private BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public void judge(final List<Car> cars) {
        int max = maxDriveLength(cars);

        for (Car car : cars) {
            printWinner(max, car);
        }
    }

    public void carsStatement(final List<Car> cars) {
        for (Car car : cars) {
            try{
                log.write(car.getName() + DELIMITER + carPosition(car));
                log.flush();
            }catch(IOException exception) {
                exception.getMessage();
            }
        }
    }

    private void printWinner(final int max, final Car car){
        if (max == car.getStep()) {
            try{
                log.write(WINNER_IS + car.getName());
                log.flush();
            }catch(IOException exception) {
                exception.getMessage();
            }
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
        for (int i = 0; i < car.getStep(); i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}

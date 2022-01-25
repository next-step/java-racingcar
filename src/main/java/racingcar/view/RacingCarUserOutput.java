package racingcar.view;

import static racingcar.model.utils.info.RacingGameInfo.WINNER_IS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import racingcar.controller.dto.OutputDTO;
import racingcar.model.entity.Car;

public class RacingCarUserOutput {

    private static final String DELIMITER = " : ";
    private static final String DASH_SIGH = "-";
    private static final String NEW_LINE = "\n";
    private static final int NUMBER_ZERO = 0;
    private final BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    private OutputDTO outputDTO;

    public OutputDTO getOutputDTO() {
        return outputDTO;
    }

    public void judge(final List<Car> cars) {
        int max = maxDriveLength(cars);
        String result = "";
        try {
            log.write(WINNER_IS);
            log.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        for (Car car : cars) {
            result += car.toString(max);
        }
        outputDTO = new OutputDTO(result);
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


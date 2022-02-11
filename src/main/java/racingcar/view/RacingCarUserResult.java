package racingcar.view;

import static racingcar.model.utils.info.RacingGameInfo.WINNER_IS;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.OutputDTO;

public class RacingCarUserResult {

    private static final String COMMAS = ",";
    private static final BufferedWriter log = new BufferedWriter(
        new OutputStreamWriter(System.out));


    public static void printWinnerCar(final List<OutputDTO> outputDto) throws Exception {
        String victory = outputDto.stream()
            .map(OutputDTO::getCarName)
            .collect(Collectors.joining(COMMAS));
        log.write(WINNER_IS + victory);
        log.flush();

    }

    public static void printCarStatus(final List<OutputDTO> cars) {
        cars.forEach(OutputDto -> {
            try {
                printCarResult(OutputDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void printCarResult(final OutputDTO outputDto) throws Exception {
        log.write(outputDto.carStatementMessage());
        log.flush();
    }

}


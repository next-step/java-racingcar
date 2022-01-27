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


    public static void judge(final List<OutputDTO> output) throws Exception {
        String victory = output.stream()
            .map(OutputDTO::getCarName)
            .collect(Collectors.joining(COMMAS));
        log.write(WINNER_IS + victory);
        log.flush();

    }

    public static void carStatus(final List<OutputDTO> cars) {
        cars.forEach(OutputDTO -> {
            try {
                carDetailStatus(OutputDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void carDetailStatus(final OutputDTO outputDTO) throws Exception {
        log.write(outputDTO.carStatementMessage());
        log.flush();
    }

}


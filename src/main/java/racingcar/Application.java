package racingcar;


import static racingcar.model.utils.common.Parsing.parsingCarName;
import static racingcar.model.utils.common.Parsing.racingTryCheck;
import static racingcar.view.RacingCarUserConsole.inputCarName;
import static racingcar.view.RacingCarUserConsole.inputRacingTry;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.InputDTO;
import racingcar.controller.dto.OutputDTO;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Racing;
import racingcar.model.domain.RandomNumberBehavior;
import racingcar.model.domain.Victory;
import racingcar.model.utils.common.StringUtils;
import racingcar.view.RacingCarUserResult;

public class Application {

    private static final int NUMBER_ZERO = 0;

    public static void main(String[] args) throws Exception {
        InputDTO inputDTO = startGame();
        Cars cars = new Cars(inputDTO.getSplitUserInput());
        Racing racing = new Racing(cars.cars(), RandomNumberBehavior.getInstance());
        for (int idx = NUMBER_ZERO; idx < inputDTO.getRacingTryCounter(); idx++) {
            racing.drive();
            List<OutputDTO> result = convertCar(cars);
            RacingCarUserResult.carStatus(result);
        }
        Victory victory = Victory.maxCheck(cars.cars());
        List<OutputDTO> victoryResult = convertVictory(victory);
        RacingCarUserResult.judge(victoryResult);
    }

    private static List<OutputDTO> convertVictory(final Victory victory) {
        return victory.victory()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
    }

    private static List<OutputDTO> convertCar(final Cars cars) {
        return cars.cars().stream().map(OutputDTO::new).collect(Collectors.toList());
    }

    private static InputDTO startGame() throws IOException {
        String name = receiveUserCarse();
        int count = userTry();
        List<String> parsingName = StringUtils.splitStr(name);
        return new InputDTO(parsingName, count);
    }

    private static int userTry() throws IOException {
        int count = 0;
        do {
            count = inputRacingTry();
        } while (racingTryCheck(count));
        return count;
    }

    private static String receiveUserCarse() throws IOException {
        String name = "";
        do {
            name = inputCarName();
        } while (parsingCarName(name));
        return name;
    }
}


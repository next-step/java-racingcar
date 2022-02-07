package racingcar.controller;

import static racingcar.model.utils.common.Validation.validateCarName;
import static racingcar.model.utils.common.Validation.validateNumberRange;
import static racingcar.view.RacingCarUserConsole.inputCarName;
import static racingcar.view.RacingCarUserConsole.inputRacingTry;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.InputDTO;
import racingcar.controller.dto.OutputDTO;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Racing;
import racingcar.model.domain.RandomMoveBehavior;
import racingcar.model.domain.Victory;
import racingcar.model.utils.common.StringUtils;
import racingcar.view.RacingCarUserResult;

public class Controller {

    private static final int NUMBER_ZERO = 0;

    public static void run() throws Exception {
        InputDTO inputDto = startGame();
        Cars cars = new Cars(inputDto.getSplitUserInput());
        Racing racing = new Racing(cars, RandomMoveBehavior.getInstance());
        for (int idx = NUMBER_ZERO; idx < inputDto.getRacingTryCounter(); idx++) {
            racing.drive();
            List<OutputDTO> result = convertCar(cars);
            RacingCarUserResult.printCarStatus(result);
        }
        Victory victory = Victory.makeVictoryCars(cars);
        List<OutputDTO> victoryResult = convertVictory(victory);
        RacingCarUserResult.printWinnerCar(victoryResult);
    }

    private static List<OutputDTO> convertVictory(final Victory victory) {
        return victory.victory()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
    }

    private static List<OutputDTO> convertCar(final Cars cars) {
        return cars.cars()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
    }

    private static InputDTO startGame() throws IOException {
        String name = receiveUserCarse();
        int count = userTry();
        List<String> parsingName = StringUtils.splitUserInput(name);
        return new InputDTO(parsingName, count);
    }

    private static int userTry() throws IOException {
        int count = 0;
        do {
            count = inputRacingTry();
        } while (validateNumberRange(count));
        return count;
    }

    private static String receiveUserCarse() throws IOException {
        String name = "";
        do {
            name = inputCarName();
        } while (validateCarName(name));
        return name;
    }
}

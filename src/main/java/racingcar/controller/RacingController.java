package racingcar.controller;

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
import racingcar.model.utils.common.Validation;
import racingcar.view.RacingCarUserResult;

public class RacingController {

    private static final int NUMBER_ZERO = 0;
    private InputDTO inputDTO;
    private String name;
    private int count;
    private List<String> parsingName;

    public void run() throws Exception {
        startGame();
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

    private List<OutputDTO> convertVictory(final Victory victory) {
        return victory.victory()
            .stream()
            .map(OutputDTO::new)
            .collect(Collectors.toList());
    }

    private List<OutputDTO> convertCar(final Cars cars) {
        return cars.cars().stream().map(OutputDTO::new).collect(Collectors.toList());
    }

    private void startGame() throws IOException {
        userCars();
        userTry();
        parsingName = StringUtils.splitStr(name);
        inputDTO = new InputDTO(parsingName, name, count);
    }

    private void userTry() throws IOException {
        do{
                count = inputRacingTry();
            }while (Validation.parsingRacingTry(count));
    }

    private void userCars() throws IOException {
        do{
            name = inputCarName();
        }while (Validation.parsingCarName(name));
    }
}

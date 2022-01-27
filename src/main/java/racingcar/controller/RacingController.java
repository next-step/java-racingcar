package racingcar.controller;

import static racingcar.view.RacingCarUserConsole.*;

import java.io.IOException;
import java.util.List;
import racingcar.controller.dto.InputDTO;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Racing;
import racingcar.model.domain.RandomNumberBehavior;
import racingcar.model.utils.common.StringUtils;
import racingcar.model.utils.common.Validation;
import racingcar.view.RacingCarUserResult;

public class RacingController {

    private static final int NUMBER_ZERO = 0;
    private InputDTO inputDTO;
    private String name;
    private int count;
    private List<String> parsingName;

    public void run() throws IOException {
        RacingCarUserResult userResult = new RacingCarUserResult();
        startGame();
        Cars cars = new Cars(inputDTO.getSplitUserInput());
        Racing racing = new Racing(cars.getCars(), RandomNumberBehavior.getInstance());
        for (int idx = NUMBER_ZERO; idx < inputDTO.getRacingTryCounter(); idx++) {
            racing.drive();
            userResult.carsStatement(racing.getCars());
        }
        userResult.judge(racing.getCars());
        System.out.println(userResult.getOutputDTO().getResultMessage());
    }

    private void startGame() throws IOException {
        userCars();
        userTry();
        parsingName =  StringUtils.splitStr(name);
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

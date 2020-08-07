package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.model.RandomMovableStrategy;
import com.hskim.nextstep.step03.ui.InputView;
import com.hskim.nextstep.step03.ui.ResultView;
import com.hskim.nextstep.step03.utils.ValidationUtils;

import java.util.List;

public class Main {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_LOWER_BOUND = 4;

    public static void main(String[] args) {

        RacingCarSimulator carSimulator;
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printPhraseToConsole("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = inputView.getStringFromConsoleInput();

        List<String> carNameList = StringUtils.getParsedStringList(carNames, RacingCarSimulator.CAR_NAME_DELIMITER);
        ValidationUtils.stringLengthLimit(carNameList,
                RacingCar.CAR_NAME_LIMIT, ExceptionMessage.EXCEED_CAR_NAME_LENGTH);


        inputView.printPhraseToConsole("시도할 회수는 몇 회 인가요?");
        int repeatCount = inputView.getIntegerFromConsoleInput();

        carSimulator = new RacingCarSimulator(carNameList, repeatCount,
                new RandomMovableStrategy(RANDOM_BOUND, MOVABLE_LOWER_BOUND));
        carSimulator.simulate();

        resultView.printRacingSimulateResult(carSimulator);
    }
}

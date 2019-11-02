package game.racing;

import game.core.view.InputView;
import game.core.view.UserInputs;

import java.io.InputStream;

/**
 * Created by yusik on 2019/11/02.
 */
public class RacingInputView extends InputView {
    private static String KEY_CAR_NAMES = "carNames";
    private static String KEY_NUMBER_OF_ROUNDS = "numberOfTimes";
    private static String NAME_DELIMITER = ",";

    public RacingInputView() {
        super();
    }

    public RacingInputView(InputStream in) {
        super(in);
    }

    public String[] getCarNames() {
        String carNames = getInputValueByKey(KEY_CAR_NAMES);
        return carNames.split(NAME_DELIMITER);
    }

    public int getNumberOfRound() {
        return Integer.parseInt(getInputValueByKey(KEY_NUMBER_OF_ROUNDS));
    }

    @Override
    public void initialize(UserInputs userInput) {
        userInput.addInputMessage(KEY_CAR_NAMES, "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        userInput.addInputMessage(KEY_NUMBER_OF_ROUNDS, "시도할 횟수는 몇 회 인가요?");
    }
}

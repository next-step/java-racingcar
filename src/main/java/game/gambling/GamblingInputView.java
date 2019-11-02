package game.gambling;

import game.InputView;
import game.UserInputs;

/**
 * Created by yusik on 2019/11/02.
 */
public class GamblingInputView extends InputView {

    public String[] getUserNames() {
        String carNames = getInputValueByKey("users");
        return carNames.split(",");
    }

    public int getNumberOfRound() {
        return Integer.parseInt(getInputValueByKey("numberOfRound"));
    }

    @Override
    public void initialize(UserInputs userInput) {
        userInput.addInputMessage("users", "도박할 사람 이름(,)");
        userInput.addInputMessage("numberOfRound", "시도 횟수");
    }
}

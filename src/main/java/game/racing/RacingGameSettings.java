package game.racing;

import game.GameSettings;
import game.UserInput;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGameSettings extends GameSettings {

    private static String KEY_CAR_NAMES = "carNames";
    private static String KEY_NUMBER_OF_TIMES = "numberOfTimes";
    private static String NAME_DELIMITER = ",";

    public String[] getCarNames() {
        String carNames = userInput.getValue(KEY_CAR_NAMES);
        return carNames.split(NAME_DELIMITER);
    }

    public int getNumberOfTimes() {
        return Integer.parseInt(userInput.getValue(KEY_NUMBER_OF_TIMES));
    }

    @Override
    public void setInputMessages(UserInput userInput) {
        userInput.addInputMessage(KEY_CAR_NAMES, "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        userInput.addInputMessage(KEY_NUMBER_OF_TIMES, "시도할 횟수는 몇 회 인가요?");
    }
}

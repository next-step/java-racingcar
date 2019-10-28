package game.racing;

import game.GameSettings;
import game.UserInput;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGameSettings extends GameSettings {

    private static String KEY_NUMBER_OF_CAR = "numberOfCar";
    private static String KEY_NUMBER_OF_TIMES = "numberOfTimes";

    public int getNumberOfCar() {
        return Integer.parseInt(userInput.getValue(KEY_NUMBER_OF_CAR));
    }

    public int getNumberOfTimes() {
        return Integer.parseInt(userInput.getValue(KEY_NUMBER_OF_TIMES));
    }

    @Override
    public void setInputMessages(UserInput userInput) {
        userInput.addInputMessage(KEY_NUMBER_OF_CAR, "자동차 대수는 몇 대 인가요?");
        userInput.addInputMessage(KEY_NUMBER_OF_TIMES, "시도할 회수는 몇 회 인가요?");
    }
}

package game.gambling;

import game.GameSettings;
import game.UserInput;

/**
 * Created by yusik on 2019/10/29.
 */
public class GamblingGameSettings extends GameSettings {

    public String[] getUserNames() {
        String carNames = userInput.getValue("users");
        return carNames.split(",");
    }

    public int getNumberOfRound() {
        return Integer.parseInt(userInput.getValue("numberOfRound"));
    }

    @Override
    public void setInputMessages(UserInput userInput) {
        userInput.addInputMessage("users", "도박할 사람 이름(,)");
        userInput.addInputMessage("numberOfRound", "시도 횟수");
    }
}

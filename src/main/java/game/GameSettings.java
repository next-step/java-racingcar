package game;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public abstract class GameSettings {

    protected UserInputs userInput;

    public void initialize() {
        userInput = new UserInputs();
        setInputMessages(userInput);
    }

    public UserInputs getUserInput() {
        return userInput;
    }

    public String getSettingValue(String key) {
        return userInput.getValue(key);
    }

    public abstract void setInputMessages(UserInputs userInput);
}

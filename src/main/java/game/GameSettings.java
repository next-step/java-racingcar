package game;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public abstract class GameSettings {

    protected UserInput userInput;

    public void initialize() {
        userInput = new UserInput();
        setInputMessages(userInput);
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public String getSettingValue(String key) {
        return userInput.getValue(key);
    }

    public abstract void setInputMessages(UserInput userInput);
}

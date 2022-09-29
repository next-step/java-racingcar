package racing.util;

public class UserIntegerInputHandler extends UserInputHandler {
    @Override
    public boolean validate(Object userInput) {
        if(userInput.getClass() == String.class) {
            return validate(String.valueOf(userInput));
        }
        return validate((int) userInput);
    }

    public boolean validate(int userInput) {
        return userInput > 0;
    }

    public boolean validate(String userInput) {
        try {
            return validate(Integer.parseInt(userInput));
        } catch (Exception e) {
            return false;
        }
    }
}

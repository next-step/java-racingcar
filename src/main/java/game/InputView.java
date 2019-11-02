package game;

import java.io.InputStream;
import java.util.*;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public abstract class InputView {

    private Scanner scanner;
    private UserInputs userInput;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream in) {
        scanner = new Scanner(in);
        userInput = new UserInputs();
    }

    public void renderAndAcceptInput() {
        initialize(userInput);
        for (Input input : userInput.getMessages()) {
            System.out.println(input.getMessage());
            input.setValue(scanner.nextLine());
        }
    }

    protected String getInputValueByKey(String key) {
        return userInput.getValue(key);
    }

    public abstract void initialize(UserInputs userInput);
}

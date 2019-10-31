package game;

import java.io.InputStream;
import java.util.*;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class InputView {

    private Scanner scanner;
    private UserInputs userInput;

    public InputView(GameSettings settings) {
        this(System.in, settings);
    }

    public InputView(InputStream in, GameSettings settings) {
        scanner = new Scanner(in);
        settings.initialize();
        userInput = settings.getUserInput();

    }

    public void render() {
        for (Input input : userInput.getMessages()) {
            System.out.println(input.getMessage());
            input.setValue(scanner.nextLine());
        }
    }
}

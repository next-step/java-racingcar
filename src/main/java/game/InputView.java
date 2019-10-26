package game;

import java.util.*;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class InputView {

    private Scanner scanner;
    private Map<String, UserInput<Integer>> inputs;

    public InputView() {
        scanner = new Scanner(System.in);
        inputs = new HashMap<>();
    }

    public void addMessage(String key, String message) {
        UserInput<Integer> input = new UserInput<>();
        input.setMessage(message);
        this.inputs.put(key, input);
    }

    public void render() {
        for (UserInput<Integer> input : inputs.values()) {
            System.out.println(input.getMessage());
            input.setValue(scanner.nextInt());
        }
    }

    public Integer getInput(String key) {
        return inputs.get(key).getValue();
    }
}

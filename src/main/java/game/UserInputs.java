package game;

import java.util.*;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class UserInputs {

    private Map<String, Input> inputs;

    public UserInputs() {
        inputs = new LinkedHashMap<>();
    }

    public void addInputMessage(String key, String message) {
        inputs.put(key, new Input(message));
    }

    public Collection<Input> getMessages() {
        return inputs.values();
    }

    public String getValue(String key) {
        return Optional.ofNullable(inputs.get(key))
                .map(Input::getValue)
                .orElse("");
    }
}

package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class UserInputs {

    private Map<String, Input> inputs;

    public UserInputs() {
        inputs = new HashMap<>();
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

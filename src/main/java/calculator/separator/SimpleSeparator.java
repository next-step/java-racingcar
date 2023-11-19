package calculator.separator;

import java.util.List;

public class SimpleSeparator implements Separator {

    @Override
    public boolean matchable(String text) {
        return text.length() == 1 && Character.isDigit(text.charAt(0));
    }

    @Override
    public List<String> separate(String text) {
        return List.of(text);
    }
}

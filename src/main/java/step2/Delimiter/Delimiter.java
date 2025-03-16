package step2.Delimiter;

import java.util.List;

public interface Delimiter {
    boolean matches(String input);
    List<String> split(String input);
}

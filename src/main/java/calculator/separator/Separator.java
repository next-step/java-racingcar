package calculator.separator;

import java.util.List;

public interface Separator {

    boolean matchable(String text);

    List<String> separate(String text);
}

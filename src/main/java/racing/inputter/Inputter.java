package racing.inputter;

import java.util.List;

public interface Inputter {

    int inputIntValue();

    List<String> inputDelimiterSeparatedStringValue(String delimiter);
}

package racinggame;

import java.util.List;
import java.util.Map;

public interface ResultView {
    void printRaceResults(Map<String, Integer> positions);
    void printResultMessage();
}

package racinggame.view;

import java.util.List;
import java.util.Map;

public interface ResultView {
    void printRaceResults(Map<String, Integer> positions);
    void printExecutionAnnouncementMessage();
    void printWinners(List<String> winners);
}

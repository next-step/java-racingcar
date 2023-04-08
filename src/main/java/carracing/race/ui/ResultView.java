package carracing.race.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class ResultView {
    private final PrintStream printStream;
    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void resultview(Map<Integer, List<Integer>> raceResults) {
    }
}

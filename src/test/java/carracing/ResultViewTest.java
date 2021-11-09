package carracing;

import org.junit.jupiter.api.Test;

public class ResultViewTest {

    @Test
    void racing() {
        ResultView resultView = new ResultView(3);
        resultView.racing();
    }

    @Test
    void printRacing() {
        ResultView resultView = new ResultView(3);
        resultView.racing();

        resultView.printRacing();
    }
}

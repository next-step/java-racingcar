package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.OutputView;

@DisplayName("OutputView Test")
public class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void OutputView_Creation() {

        System.out.println("Hello World!");
    }
}

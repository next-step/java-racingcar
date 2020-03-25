package fifthrefactoring.view;

import fifthrefactoring.domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private ResultView resultview = new ResultView();


    @Test
    void makeSignTest() {
        assertThat(resultview.makeSign(3)).isEqualTo("---");
    }

}

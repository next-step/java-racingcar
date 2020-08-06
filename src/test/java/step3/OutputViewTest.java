package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OutputView Test")
public class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void OutputView_GetDashDistance() {
        assertThat(outputView.getDashDistance(4)).isEqualTo("----");
    }
}

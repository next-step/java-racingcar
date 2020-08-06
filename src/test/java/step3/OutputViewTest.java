package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OutputView Test")
public class OutputViewTest {

    @Test
    void OutputView_GetDashDistance() {
        assertThat(OutputView.getDashDistance(4)).isEqualTo("----");
    }

}

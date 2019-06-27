package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.DashTrackingMonitorView;
import racing.view.RacingMonitorView;
import racing.vo.StageOption;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameStageControllerTest {

    @Test
    @DisplayName("스테이지 생성 테스트")
    void create() {

        // Arrange
        List<String> messageFormView = new ArrayList<>();
        RacingMonitorView view = new DashTrackingMonitorView(message -> messageFormView.add(message));
        StageOption option = new StageOption("A,B", ",", 1);

        // Action
        Stage stage = GameStageController.create(option, view);
        stage.play();

        // Assertion
        assertThat(stage.getCountOfPlayers()).isEqualTo(2);
        assertThat(messageFormView.get(1)).startsWith("A");
    }
}
package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    @DisplayName("경주가 시작된 후 차들의 전진 상태를 저장한다.")
    @Test
    void save_cars_moveStatus_after_carRacing_starts() {
        CarRacing carRacing = CarRacing.builder().cars(1).build();
        carRacing.getCars().get(0).move(4);

        ResultView resultView = new ResultView();

        resultView.saveCarsMoveStatus(carRacing.getCars());

        assertThat(resultView.getOutput()).hasToString("실행 결과\n-\n\n");
    }
}
package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService target = new RacingService();
    private ResultView resultView = new ResultView();

    @Test
    @DisplayName("레이싱 경주 시작 메서드 호출 성공")
    void start() {
        // given
        int cars = 3;
        int attempts = 5;

        // when
        resultView = target.start(cars, attempts);

        // then
        assertThat(target.getCars()).hasSize(cars);
        assertThat(resultView.getResult()).isNotBlank();
    }

}

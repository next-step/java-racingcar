package racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultViewTest {

    @DisplayName("자동차 게임의 우승자 결과 표기 테스트")
    @Test
    void printWinner() {
        String result = ResultView.printWinner(List.of("A","B"));
        assertThat(result).isEqualTo("A, B가 최종 우승했습니다.");
    }

    @DisplayName("자동차경기 라운드별 자동차이름과 위치 표기 테스트")
    @Test
    void printCarPosition() {
        String result = ResultView.printCarPosition(new Car("A",4));
        assertThat(result).isEqualTo("A : ----");
    }
}

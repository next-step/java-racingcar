package racingGame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    @DisplayName("입력받은 Car를 resultMessage (name : ---) 꼴로 변환한다")
    void parseCarToResultMessage() {
        String result = ResultView.parseCarToResultMessage(new Car("pobi", 3));
        assertThat(result).isEqualTo("pobi : ---");
    }
}

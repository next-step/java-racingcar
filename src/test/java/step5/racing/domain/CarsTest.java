package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차가_한_대만_존재하면_예외가_발생한다() {
        List<String> carNames = List.of("자동차1");

        assertThatThrownBy(() -> new Cars(new CarNames(carNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_자동차의_대수만큼_자동차가_생성된다() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        Cars cars = new Cars(new CarNames(carNames));

        assertThat(cars.size()).isEqualTo(carNames.size());
    }
}

package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Names 객체 테스트")
public class InputNamesTest {

    @Test
    void 콤마와함께_자동차이름을_복수로_입력하면_자동차이름_리스트를_반환받는다() {
        InputNames inputNames = new InputNames("aaaa, bbbbb, ccc");
        List<String> carNames = inputNames.getCarNames();

        Assertions.assertThat(carNames.size()).isEqualTo(3);
        Assertions.assertThat(carNames)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly("aaaa", "bbbbb", "ccc");
    }
}

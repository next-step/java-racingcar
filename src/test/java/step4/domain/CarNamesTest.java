package step4.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {
    private static final String CAR_NAMES_FOR_TEST = "car1,car2,car3";

    @Test
    void 문자열로_입력받은_자동차이름들을_List로_저장한다() {
        List<String> testList = Arrays.asList("car1", "car2", "car3");
        CarNames carNames = new CarNames(CAR_NAMES_FOR_TEST);

        assertThat(carNames.getCarNames()).isEqualTo(testList);
    }

    @Test
    void 문자열로_입력받은_자동차이름들을_일급콜렉션_CarNames로_저장한다() {
        assertThat(CarNames.from(CAR_NAMES_FOR_TEST)).isInstanceOf(CarNames.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 입력된_이름대로_자동차의_이름들이_생성된다(int num) {
        CarNames carNames = CarNames.from(CAR_NAMES_FOR_TEST);

        assertThat(carNames.getCarNames().get(num)).isEqualTo("car" + (num + 1));
    }
}

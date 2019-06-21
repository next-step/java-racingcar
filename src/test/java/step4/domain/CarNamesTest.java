package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {
    @Test
    void 문자열로_입력받은_자동차이름들을_List로_저장한다() {
        String testCarNames = "car1,car2,car3";
        CarNames carNames = new CarNames(testCarNames);
        List<String> testList = Arrays.asList("car1", "car2", "car3");

        assertThat(carNames.getCarNames()).isEqualTo(testList);
    }

    @Test
    void CarN() {
        CarNames.from("");
    }
}

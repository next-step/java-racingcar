package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.RacingCars;

import java.util.Arrays;

class RacingCarsTest {

    @ParameterizedTest
    @CsvSource(value = {"a,b,c,d|4", "poby,kero,cat|3", "rian,con|2", "java,ruby,sql,boot,test,tdd|6"}, delimiter = '|')
    @DisplayName("생성자 인자로 전달받은 이름 갯수만큼 자동차 객체를 생성한다")
    public void createTest(String name, int expected) {

        RacingCars racingCars = new RacingCars(Arrays.asList(name.split(",")));

        Assertions.assertThat(racingCars.currentCars()).hasSize(expected);
    }
}

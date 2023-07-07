package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("라운드 정상 진행 테스트")
    @ParameterizedTest
    @CsvSource({"0,1", "3,1", "4,2", "9,2"})
    void nextStepTest(int generatedNumber, int expected) {
        //given
        NumberGenerator numberGenerator = new SpecificNumberGenerator(generatedNumber);
        Cars cars = new Cars(Arrays.asList("test1", "test2"));

        //when
        List<CarVO> result = cars.nextStep(numberGenerator);

        //then
        assertThat(result.get(0).getPosition()).isEqualTo(expected);
        assertThat(result.get(1).getPosition()).isEqualTo(expected);
    }

    @DisplayName("우승자 정상 반환 테스트")
    @Test
    void getWinnersTest() {
        //given
        Cars cars = new Cars(Arrays.asList("test2", "test3"));

        //when
        List<CarVO> result = cars.getWinners();

        //then
        assertThat(result.get(0).getName()).isEqualTo("test2");
        assertThat(result.get(1).getName()).isEqualTo("test3");
    }

}

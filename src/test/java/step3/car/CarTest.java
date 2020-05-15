package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.generator.TestNumberGenerator;
import step3.generator.GenerateNumberStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"1,0", "4,1", "3,0", "5,1"})
    @DisplayName("car 의 numberGenerator 의 번호가 4 이상인 경우만 position 이 증가한다. ")
    public void moveTest(int input, int expected){

        // given
        Car car = new Car();
        GenerateNumberStrategy generator = new TestNumberGenerator(input);

        // when
        int position = car.move(generator);

        // then
        assertThat(position).isEqualTo(expected);
    }
}

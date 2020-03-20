package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumGeneratorTest {
    @DisplayName("10 이하의 숫자만 발생된다.")
    @Test
    void generateNumberLessThanTenTest(){
        //given
        RandomNumGenerator generator = new RandomNumGenerator();

        //when
        int random = generator.generateNumberLessThan(10);

        //then
        assertThat(random).isLessThan(10);
    }
}

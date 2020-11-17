package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("10이하 난수 생성 테스트")
    public void randomNumberTest(){
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.makeNumber()).isLessThan(10);

    }

    @Test
    @DisplayName("숫자 비교 테스트")
    public void numberBiggerTest(){
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.isBigger(5)).isEqualTo(1);
    }

}

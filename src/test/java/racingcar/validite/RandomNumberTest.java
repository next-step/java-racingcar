package racingcar.validite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @DisplayName("랜덤 숫자가 0보다 큰지 테스트")
    @Test
    void randomNumber_0이상값_생성_Test() {
        //given
        //when
        int createNumber = RandomNumber.randomNumberCreate();
        //then
        assertThat(createNumber).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("랜덤 숫자가 9이하인지 테스트")
    @Test
    void randomNumber_9이하값_생성_Test() {
        //given
        //when
        int createNumber = RandomNumber.randomNumberCreate();
        //then
        assertThat(createNumber).isLessThan(10);
    }
}

package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Moving;

@DisplayName("움직임 테스트")
public class MovingTest {

    @DisplayName("랜덤 숫자 중 0부터 3까지를 반환받을 경우 false 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false"}, delimiter = ':')
    void 전진하지_않는_조건_테스트(int input, boolean expected) {
        Moving moving = new Moving();

        boolean result = moving.move(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("랜덤 숫자 중 4부터 9까지를 반환받을 경우 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진하는_조건_테스트(int input, boolean expected) {
        Moving moving = new Moving();

        boolean result = moving.move(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}

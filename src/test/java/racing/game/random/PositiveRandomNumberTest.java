package racing.game.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 양수 생성기 테스트")
class PositiveRandomNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4 })
    void 주어진_숫자_이하의_랜덤값을_생성한다(int bound) {
        RandomNumber random = new PositiveRandomNumber();
        assertThat(random.generate(bound)).isLessThanOrEqualTo(bound);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void _0_미만의_숫자는_나오지_않는다(int bound) {
        RandomNumber random = new PositiveRandomNumber();
        assertThat(random.generate(bound)).isNotNegative();
    }
}

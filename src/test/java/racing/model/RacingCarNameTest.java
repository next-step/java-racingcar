package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("자동차 이름 테스트")
public class RacingCarNameTest {

    @DisplayName("RacingCarName 객체 생성시 주입받은 문자 값을 그대로 갖는다.")
    @Test
    public void initialRacingCarNameImmutabilityTest() {
        // given
        String name = "aiden";

        // when
        RacingCarName racingCarName = RacingCarName.valueOf(name);

        // then
        assertEquals(racingCarName.getName(), name);
    }

    @DisplayName("자동차 이름이 null이면, IllegalArgumentException이 발생한다")
    @Test
    public void nullExceptionTest() {
        // given
        String name = null;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarName.valueOf(name))
                .withMessage("자동차 이름이 비었습니다.");
    }

    @DisplayName("자동차 이름이 공백이면, IllegalArgumentException이 발생한다")
    @Test
    public void blankExceptionTest() {
        // given
        String name = "";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarName.valueOf(name))
                .withMessage("자동차 이름이 비었습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하면, IllegalArgumentException이 발생한다")
    @Test
    public void outOfBoundsExceptionTest() {
        // given
        String name = "aikeun";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarName.valueOf(name))
                .withMessage("자동차 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("이전에 이미 생성된 RacingCarName 객체와 이름이 같으면, 같은 객체를 재사용한다.")
    @Test
    public void sameNameReuseTest() {
        // given, when, then
        assertSame(RacingCarName.valueOf("aiden"), RacingCarName.valueOf("aiden"));
    }
}

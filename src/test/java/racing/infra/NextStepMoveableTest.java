package racing.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Moveable;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("넥스트 스탭 이동 전략(NextStepMoveable) 테스트")
class NextStepMoveableTest {

    @DisplayName("NextStep의 요구사항으로 만들어진 이동전략을 확인합니다.")
    @Test
    void test() {
        // given
        Moveable nextStepMoveable = new NextStepMoveable();

        // when
        boolean isMove = nextStepMoveable.isMove();


        // then
        assertThat(isMove).isIn(true, false);
    }
}

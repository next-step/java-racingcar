package domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    public void carNameList가_null인경우_exception을_던진다() {
        assertThatThrownBy(() -> new Racing(null, 10))
            .hasMessageContaining("carNameList는 null일 수 없습니다.");
    }

    @Test
    public void carNameList가_빈경우_exception을_던진다() {
        assertThatThrownBy(() -> new Racing(new String[]{}, 10))
            .hasMessageContaining("자동차 대수는 0 이상을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 회수가_0이하인경우_exception을_던진다(int tryCount) {
        String[] carNameList = new String[]{"kim", "cheol"};
        assertThatThrownBy(() -> new Racing(carNameList, tryCount))
            .hasMessageContaining("회수는 0 이상을 입력해주세요.");
    }

    @Test
    public void moveOnce시_남은시도가_차감된다() {
        String[] carNameList = new String[]{"kim", "cheol"};
        Racing racing = new Racing(carNameList, 1);
        assertThat(racing.isRemainTry()).isEqualTo(true);
        racing.moveOnce();
        assertThat(racing.isRemainTry()).isEqualTo(false);
    }
}

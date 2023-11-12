package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.NameSplitter;

public class NameSplitterTest {

    @Test
    @DisplayName(", 를 사용하여 참가할 자동차들의 이름을 구분한다")
    void splitCarName() {
        List<String> carNames = NameSplitter.splitUserName("sonata,avante,g70,m320i");
        assertThat(carNames).hasSize(4);
    }

}

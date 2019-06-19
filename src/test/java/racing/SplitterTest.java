package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Splitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName("스플리터의 콤마 스플릿 기능 테스트")
    @Test
    void splitWithComma() {
        List<String> carNames = Splitter.spiltWithComma("hellworld,comma,javajigi");
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("hellworld");
        assertThat(carNames.get(1)).isEqualTo("comma");
        assertThat(carNames.get(2)).isEqualTo("javajigi");
    }
}

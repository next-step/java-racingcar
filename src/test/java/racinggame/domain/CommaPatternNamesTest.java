package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CommaPatternNamesTest {

    @Test
    public void 숫자_두개_분리_테스트() {
        List<String> split = new CommaPatternNames("1,2").split();
        assertThat(split).hasSize(2);
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    public void 숫자_한개_분리_테스트() {
        assertThatThrownBy(()->new CommaPatternNames(null)).isInstanceOf(NullPointerException.class);
    }
}

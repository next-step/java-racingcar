package nextstep.javaracingcar.step02;

import nextstep.javaracingcar.step2.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static nextstep.javaracingcar.step2.PositiveNumber.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @DisplayName("문자열을 입력해서 생성할 수 있다.")
    @Test
    public void spec01() {
        assertThat(from("1")).isEqualTo(from(1));
    }

    @DisplayName("음수는 허용되지 않는다.")
    @Test
    public void spec02() {
        assertThatThrownBy(() -> from("-1")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> from(-1)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("더할 수 있다.")
    @Test
    public void spec03() {
        final PositiveNumber one = from("1");
        assertThat(one.plus(one)).isEqualTo(from("2"));
    }

    @DisplayName("현재 수 만큼 반복할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 40})
    public void spec04(final int count) {
        final PositiveNumber countNumber = from(count);
        final List<Integer> loopCount = new ArrayList<>();
        countNumber.loop(loopCount::add);
        assertThat(loopCount).hasSize(count);
    }

    @DisplayName("비교할 수 있다.")
    @Test
    public void spec05() {
        final PositiveNumber one = from("1");
        final PositiveNumber two = from("2");
        assertThat(one.compareTo(two)).isEqualTo(-1);
        assertThat(two.compareTo(one)).isEqualTo(1);
        assertThat(one.compareTo(from("1"))).isEqualTo(0);
        assertThat(two.compareTo(from("2"))).isEqualTo(0);
    }
}

package newRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {
    @Test
    void 이름_길이_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Name name = new Name("mincho");
                });
    }

    @Test
    void 동일_이름_객체_테스트() {
        Name min = new Name("min");
        assertThat(new Name("min")).isEqualTo(min);
    }
}

package racingcar.domain;

import org.codehaus.plexus.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {
    @ParameterizedTest
    @NullAndEmptySource
    void checkValidName(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Name name1 = new Name(name);
                });
    }

    @Test
    void equals() {
        assertThat(new Name("A").equals(new Name("A"))).isEqualTo(true);
        assertThat(new Name("BAC").equals(new Name("BAC"))).isEqualTo(true);
        assertThat(new Name("ABC").equals(new Name("CBA"))).isEqualTo(false);
    }
}

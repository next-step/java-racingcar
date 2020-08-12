package cc.oakk.racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "\n" })
    @NullSource
    void construct_ShouldThrow_IllegalArgumentException_OnEmptyString(String source) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(source));
    }
}

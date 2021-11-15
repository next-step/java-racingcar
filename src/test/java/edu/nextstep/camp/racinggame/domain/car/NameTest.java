package edu.nextstep.camp.racinggame.domain.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    private static final String TEST0 = "test0";
    private static final String TEST1 = "test1";

    private static final String INVALID_NAME0 = "test-0";
    private static final String INVALID_NAME1 = "test-1";

    @ParameterizedTest
    @ValueSource(strings = {TEST0, TEST1})
    public void create(String testName) {
        assertThat(Name.of(testName).toString()).isEqualTo(testName);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {INVALID_NAME0, INVALID_NAME1})
    public void createFailed(String testName) {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.of(testName));
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ValueSource(strings = {"LeahJiin", "Samuel", "JiinLee"})
    @ParameterizedTest
    void 자동차의_이름이_5글자_넘으면_예외_발생(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(name));
    }

    @ValueSource(strings = {"Leah", "Sam", "Jiin"})
    @ParameterizedTest
    void 자동차의_이름이_정상적으로_생성(final String name) {
       Name carName = new Name(name);
       assertThat(carName.getCarName()).isEqualTo(name);
    }
}
package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNamesTest {

    private final List<CarName> names = List.of(
            new CarName("자동차1"), new CarName("자동차1"), new CarName("자동차2")
    );

    @Test
    void 자동차_이름이_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

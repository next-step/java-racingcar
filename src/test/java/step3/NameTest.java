package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void 자동차_이름_blank테스트() throws Exception {
        assertThatThrownBy(() -> {
            new Car(new Name(""), new Position(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자리테스트() throws Exception {
        assertThatThrownBy(() -> {
            new Car(new Name("sonata"), new Position(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

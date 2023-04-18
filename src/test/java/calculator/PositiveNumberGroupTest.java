package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberGroupTest {

    @Test
    void create() {
        PositiveGroup positiveGroup = PositiveGroup.create(new String[] {"3"});
        assertThat(positiveGroup.getSum()).isEqualTo(3);
    }

    @Test
    void getSum을_호출하면_가지고있는_멤버들의_합을_리턴한다() {
        PositiveGroup positiveGroup = PositiveGroup.create(new String[] {"3", "2", "1"});

        assertThat(positiveGroup.getSum()).isEqualTo(6);
    }

    @Test
    void create_음수를_전달하면_RuntimeException() {
        assertThatThrownBy(() -> PositiveGroup.create(new String[] {"-3"}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void create_숫자_이외의_값을_전달하면_RuntimeException() {
        assertThatThrownBy(() -> PositiveGroup.create(new String[] {"HELLO"}))
                .isInstanceOf(RuntimeException.class);
    }
}

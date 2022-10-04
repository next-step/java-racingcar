package game.domain.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoundTest {

    @Test
    void create(){
        Bound bound = new Bound(5);

        Assertions.assertThat(bound).isEqualTo(new Bound(5));
    }

    @Test
    void valid(){
        Assertions.assertThatThrownBy(() -> new Bound(0)).isInstanceOf(IllegalArgumentException.class);
    }
}

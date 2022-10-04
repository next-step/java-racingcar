package game.domain.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForwardNumberTest {

    @Test
    void create(){
        ForwardNumber forwardNumber = new ForwardNumber(4);

        Assertions.assertThat(forwardNumber).isEqualTo(new ForwardNumber(4));
    }
}

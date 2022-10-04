package game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    void create(){
        Round round = new Round(5);
        Assertions.assertThat(round).isEqualTo(new Round(5));
    }
}

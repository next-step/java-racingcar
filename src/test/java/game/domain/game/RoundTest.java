package game.domain.game;

import game.domain.game.Round;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    @Test
    void create(){
        Round round = new Round(5);
        assertThat(round).isEqualTo(new Round(5));
    }

    @Test
    void valid(){
        assertThatThrownBy(() -> new Round(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}

import entity.race.RaceRound;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RaceRoundTest {

    @Test
    @DisplayName("entity.race.RaceRound 생성 Test")
    public void RaceRound_Constructor_Test(){
        //given
        RaceRound race = RaceRound.of(2);

        assertThat(race.getValue()).isEqualTo(2);
        //when

        //then
    }

    @Test
    @DisplayName("entity.race.RaceRound 생성 Exception")
    public void Exception_Test() {
        assertThatThrownBy(()->{
            RaceRound.of(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 양수여야 합니다.");
    }
}
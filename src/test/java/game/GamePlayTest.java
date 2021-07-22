package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamePlayTest {

    private GamePlay gamePlay;

    @BeforeEach
    void setup() {
        gamePlay = new GamePlay();
    }

    @Test
    @DisplayName("자동차는 입력값의 , 에따라 생성된다.")
    public void createPayerBySplit() {
        List<Player> playerList1 = gamePlay.createPlayer("car1,car2,car3");

        Assertions.assertThat(playerList1.size()).isEqualTo(3);

        List<Player> playerList2 = gamePlay.createPlayer("car1,car2,");

        Assertions.assertThat(playerList2.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과하면 예외가 발생된다.")
    public void createPayerNameLimit_check() {
        assertThatThrownBy(() -> gamePlay.createPlayer("naming,para,you"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

    @Test
    @DisplayName("자동차는 최소 1대이상 아니면 예외가 발생된다.")
    public void createPayerAtListOne_check() {
        assertThatThrownBy(() -> gamePlay.createPlayer(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 한다.");
    }

}

package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.NamingCar;
import racingGame.racingRule.FowardRule;
import racingGame.racingRule.NotMoveRule;

import static org.assertj.core.api.Assertions.assertThat;

class NamingCarTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("입력 받은 이름을 반환한다.")
    void getName(){
        NamingCar namingCar = new NamingCar("test", fowardRule);
        namingCar.move();

        assertThat(namingCar.getCarName()).isEqualTo("test");
    }


    @Test
    @DisplayName("최중 움직인 회수를 반환")
    void getMaxSize(){
        NamingCar namingCar = new NamingCar("T",fowardRule);
        namingCar.move();
        assertThat(namingCar.getTraceSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("안 움직이면 최종 사이즈가 0")
    void notMove(){
        NamingCar namingCar = new NamingCar("T",new NotMoveRule());
        namingCar.move();
        assertThat(namingCar.getTraceSize()).isEqualTo(0l);
    }

    @Test
    @DisplayName("나누는 문자와, 차의 이동을 알려주는 문자를 받으면 조합해서 회당 결과를 보여준다.")
    void convert_trace(){
        NamingCar namingCar = new NamingCar("T",fowardRule);
        namingCar.move();
        namingCar.convertRound(":","-");
        assertThat(namingCar.convertRound(":","-")).isEqualTo("T:-");
    }
}
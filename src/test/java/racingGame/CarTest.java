package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.racingRule.FowardRule;
import racingGame.racingRule.NotMoveRule;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("입력 받은 이름을 반환한다.")
    void getName(){
        Car car = new Car("test");
        car.move(fowardRule);

        assertThat(car.getCarName()).isEqualTo("test");
    }


    @Test
    @DisplayName("최중 움직인 회수를 반환")
    void getMaxSize(){
        Car car = new Car("T");
        car.move(fowardRule);
        assertThat(car.getTraceSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("나누는 문자와, 차의 이동을 알려주는 문자를 받으면 조합해서 회당 결과를 보여준다.")
    void convert_trace(){
        Car car = new Car("T");
        car.move(fowardRule);
        car.convertRound(":","-");
        assertThat(car.convertRound(":","-")).isEqualTo("T:-");
    }
}
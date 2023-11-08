package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.SimpleRacingCarGame;

class SimpleRacingCarGameTest {

    @Test
    void 입력한_자동차_갯수만큼_자동차_생성() {
        int carCount = 5;
        int round = 3;
        SimpleRacingCarGame game = new SimpleRacingCarGame(carCount);
        assertThat(game.joinCars()).hasSize(carCount);
    }

    @Test
    void 랜덤_값이_4이상일_경우_전진() {
        Car car = new Car();
        boolean isFourOrMoreRandomValue = car.movedForwardIfCan();
        int movedPosition = car.getCurrentPosition();
        if(isFourOrMoreRandomValue){
            assertThat(movedPosition).isEqualTo(2);
        }
        if(!isFourOrMoreRandomValue){
            assertThat(movedPosition).isEqualTo(1);
        }
    }

    @Test
    void 자동차_경주_1라운드_정상_실행(){
        List<Car> cars = new ArrayList<>();
        SimpleRacingCarGame game = new SimpleRacingCarGame(cars);
        assertThatCode(()->game.moveOneRound(cars)).doesNotThrowAnyException();
    }

}

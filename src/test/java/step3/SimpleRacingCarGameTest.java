package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.SimpleRacingCarGame;

class SimpleRacingCarGameTest {

    @Test
    void 입력한_자동차_갯수만큼_자동차_생성() {
        int carCnt = 5;
        int round = 3;
        SimpleRacingCarGame game = new SimpleRacingCarGame(carCnt);
        assertThat(game.joinCars()).hasSize(carCnt);
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
        int carCnt = 5;
        SimpleRacingCarGame game = new SimpleRacingCarGame(carCnt);
        assertThatCode(()->game.moveOneRound(cars)).doesNotThrowAnyException();
    }

}

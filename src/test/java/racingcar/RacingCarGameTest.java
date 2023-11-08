package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.common.utils.TextManipulator;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

class RacingCarGameTest {

    @Test
    void 입력한_자동차_이름_갯수만큼_해당_이름을_가진_자동차_생성() {
        String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
        String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
        RacingCarGame game = new RacingCarGame(carNames);
        assertThat(game.joinCars()).hasSize(carNames.length);
    }

    @Test
    void 자동차_이름이_5자를_초과할_경우_에러() {
        String carNamesInOneText = "aaaaaa";
        String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
        RacingCarGame game = new RacingCarGame(carNames);
        assertThatThrownBy(game::joinCars).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_값이_4이상일_경우_전진() {
        Car car = new Car("name");
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
        String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
        String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
        RacingCarGame game = new RacingCarGame(carNames);
        assertThatCode(()->game.moveOneRound(game.joinCars())).doesNotThrowAnyException();
    }

}

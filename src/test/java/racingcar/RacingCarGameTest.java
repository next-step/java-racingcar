package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.common.utils.TextManipulator;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Winners;

class RacingCarGameTest {

    @Test
    void 입력한_자동차_이름_갯수만큼_해당_이름을_가진_자동차_생성() {
        String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
        int round = 5;
        String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
        RacingCarGame game = new RacingCarGame(round, carNames);
        assertThat(game.cars()).hasSize(carNames.length);
    }

    @Test
    void 자동차_이름이_5자를_초과할_경우_에러() {
        String text = "aaaaaa";
        assertThatThrownBy(() ->new Car(text)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_값이_4이상일_경우_전진() {
        Car car = new Car("name");
        int randomNo = 4;
        car.movedForwardIfCan(randomNo);
        assertThat(car.currentPosition().getNumber()).isEqualTo(2);
    }

    @Test
    void 랜덤_값이_4미만일_경우_전진하지_않음() {
        Car car = new Car("name");
        int randomNo = 3;
        car.movedForwardIfCan(randomNo);
        assertThat(car.currentPosition().getNumber()).isEqualTo(1);
    }

    @Test
    void 자동차_경주_1라운드_정상_실행(){
        String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
        int round = 5;
        String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
        RacingCarGame game = new RacingCarGame(round, carNames);
        assertThatCode(()->game.moveOneRound()).doesNotThrowAnyException();
    }

    @Test
    void 우승자_찾기(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        Car car4 = new Car("car4");
        car1.currentPosition().addOnePosition();
        car2.currentPosition().addOnePosition();
        List<Car> cars = List.of(car1, car2, car3, car4);
        List<Car> winners = List.of(car1, car2);
        assertThat(Winners.findWinners(cars).containsAll(winners)).isTrue();
    }

}

package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.common.utils.TextManipulator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;
import racingcar.model.Positions;
import racingcar.model.RacingCarGame;

@TestMethodOrder(OrderAnnotation.class)
class RacingCarGameTest {

        @Test
        @Order(1)
        void 입력한_자동차_이름_갯수만큼_해당_이름을_가진_자동차_생성() {
                String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
                int round = 5;
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
                RacingCarGame game = new RacingCarGame(round, carNames);
                assertThat(game.cars().getCars()).hasSize(carNames.length);
        }

        @Test
        @Order(2)
        void 자동차_이름이_5자를_초과할_경우_에러() {
                String text = "aaaaaa";
                assertThatThrownBy(() -> new Car(text)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @Order(3)
        void 랜덤_값이_4이상일_경우_전진() {
                Car car = new Car("name");
                int randomNumber = 4;
                car.movedForwardIfCan(randomNumber);
                assertThat(car.currentPosition().getNumber()).isEqualTo(2);
        }

        @Test
        @Order(4)
        void 랜덤_값이_4미만일_경우_전진하지_않음() {
                Car car = new Car("name");
                int randomNumber = 3;
                car.movedForwardIfCan(randomNumber);
                assertThat(car.currentPosition().getNumber()).isEqualTo(1);
        }

        @Test
        @Order(5)
        void 자동차_경주_1라운드_정상_실행() {
                String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
                int round = 5;
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
                RacingCarGame game = new RacingCarGame(round, carNames);
                assertThatCode(() -> game.moveOneRound()).doesNotThrowAnyException();
        }

        @Test
        @Order(6)
        void 위치_최댓값_찾기() {
                Position position1 = new Position();
                Position position2 = new Position();
                Position position3 = new Position();
                Position position4 = new Position();
                position1.addOnePosition();
                position2.addOnePosition();
                position2.addOnePosition();
                Positions positions = new Positions(List.of(position1, position2, position3, position4));
                assertThat(positions.getMaxPosition().getNumber()).isEqualTo(3);
        }

        @Test
        @Order(7)
        void 우승자_찾기() {
                Car car1 = new Car("car1");
                Car car2 = new Car("car2");
                Car car3 = new Car("car3");
                Car car4 = new Car("car4");
                car1.currentPosition().addOnePosition();
                car2.currentPosition().addOnePosition();
                List<Car> winners = List.of(car1, car2);
                Cars cars = new Cars(List.of(car1, car2, car3, car4));
                assertThat(cars.findWinners().containsAll(winners)).isTrue();
        }
}

package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.game.Game;
import step3.game.GameDto;
import step3.model.Car;
import step3.move.BasicMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤 숫자 만들기 테스트")
    @RepeatedTest(50)
    public void makeNumber() {
        //given
        BasicMoveStrategy basicMoveStrategy = new BasicMoveStrategy();
        int min = 0;
        int max = 9;

        //when
        int number = basicMoveStrategy.makeNumber();

        //then
        assertThat(number)
            .isGreaterThanOrEqualTo(min)
            .isLessThanOrEqualTo(max);
    }

    @ParameterizedTest
    @DisplayName("Game 만들기 테스트")
    @CsvSource(value = {"3:4", "2:5", "10:11", "4:5", "1:1"}, delimiter = ':')
    public void makeGame(int carCount, int count) {
        //given
        GameDto gameDto = GameDto.of(carCount, count);

        //when
        Game game = gameDto.createGame();

        //then
        assertThat(game.countOfGame()).isEqualTo(count);
        assertThat(game.cars().countOfCars()).isEqualTo(carCount);
    }

    @DisplayName("최대 한칸만 움직일 수 있는지 테스트")
    @RepeatedTest(50)
    public void mapStrategy() {
        //given
        Car car = new Car(new BasicMoveStrategy());

        //when
        car.move();

        //then
        assertThat(car.getPointOfTime(1)).isLessThanOrEqualTo(1);
    }
}

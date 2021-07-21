package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.game.Game;
import step4.game.GameDto;
import step4.model.Car;
import step4.move.BasicMoveStrategy;

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
    @CsvSource(value = {"a,b,c:4", "a,b:5", "a:11", "a,b,c,d,e:5", "a,b,c,d,e,f,g:1"}, delimiter = ':')
    public void makeGame(String names, int count) {
        //given
        GameDto gameDto = GameDto.of(names, count);

        //when
        Game game = gameDto.createGame();

        //then
        assertThat(game.countOfGame()).isEqualTo(count);
        assertThat(game.cars().countOfCars()).isEqualTo(names.split(",").length);
    }

    @DisplayName("최대 한칸만 움직일 수 있는지 테스트")
    @RepeatedTest(50)
    public void mapStrategy() {
        //given
        Car car = new Car("a");

        //when
        car.move(new BasicMoveStrategy());

        //then
        assertThat(car.getPointOfTime(1).getPoint()).isLessThanOrEqualTo(1);
    }
}

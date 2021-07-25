package racing.domain.game.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.CarsTest;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;
import racing.domain.game.vo.turn.Turns;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {
    private static CarsTest carsTest;
    private static Fuel fuel;

    @BeforeAll
    public static void setUp() {
        carsTest = new CarsTest();
        fuel = new RandomFuel();
    }

    private RacingGame initRacingGame(String strBasicCarNames, int turnSize) {
        return new RacingGame(
                new Turns(turnSize),
                carsTest.initCars(strBasicCarNames, BasicCar::new),
                fuel
        );
    }

    @CsvSource({
            "A|B|C,100",
            "A|B|C,100",
            "A|B|C|D|E|F,100"
    })
    @DisplayName("ctor 테스트")
    @ParameterizedTest
    public void ctorTest(String strBasicCarNames, int turnSize) {
        initRacingGame(strBasicCarNames, turnSize);
    }

    @DisplayName("ctor IllegalArgumentException 테스트")
    @Test
    public void ctorIllegalArgumentExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new RacingGame(
                        null,
                        null,
                        null)
        );
        assertThatIllegalArgumentException().isThrownBy(() ->
                new RacingGame(
                        null,
                        null,
                        fuel)
        );
        assertThatIllegalArgumentException().isThrownBy(() ->
                new RacingGame(
                        null,
                        carsTest.initCars("AA", BasicCar::new),
                        fuel)
        );
        assertThatIllegalArgumentException().isThrownBy(() ->
                new RacingGame(
                        new Turns(1),
                        null,
                        fuel)
        );
    }

    @DisplayName("racingAll, isEnded 테스트")
    @CsvSource({
            "A|B|C,100",
            "A|B|C,100",
            "A|B|C|D|E|F,100"
    })
    @ParameterizedTest
    public void racingAllTest(String strBasicCarNames, int turnSize) {
        RacingGame racingGame = initRacingGame(strBasicCarNames, turnSize);
        racingGame.racingAll();

        assertThat(
                racingGame.isEnded()
        ).isTrue();
    }
}
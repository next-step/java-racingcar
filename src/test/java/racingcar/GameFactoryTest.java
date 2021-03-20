package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class GameFactoryTest {

    private GameFactory gameFactory;
    private static final int TRY_NUM = 3;
    private static final int CAR_NUM = 4;
    private List<Object> inputs;

    @BeforeEach
    void setUp() {
        gameFactory = new GameFactory();
        inputs = new ArrayList<>();
        inputs.add(CAR_NUM);
        inputs.add(TRY_NUM);
    }

    @Test
    @DisplayName("Car의 생성 주관을 GameFactory에서 하는 테스트")
    void buildCar() {
        Car car = gameFactory.car();
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car).extracting("random")
                .hasOnlyElementsOfType(Random.class);
    }


    @Test
    @DisplayName("Cars 생성을 GameFactory에서 주관하여 Car의 생성과 Cars의 생성을 통합테스트")
    void buildCars() {
        Cars cars = gameFactory.cars(CAR_NUM);
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("Game의 생성을 GameFactory에서 주관하여 Game, Cars, Car의 생성을 통합테스트")
    void buildGame() {
        MockedStatic<InputView> inputView = mockStatic(InputView.class);
        when(InputView.input(new String[]{Game.HOW_MANY_CARS, Game.HOW_MANY_TRYS}))
                .thenReturn(inputs);
        assertThat(gameFactory.step3Game()).isInstanceOf(Game.class);
        inputView.close();
    }
}

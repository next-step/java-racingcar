package step3.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import step3.racingCar.domain.Car;
import step3.racingCar.domain.Cars;
import step3.racingCar.ui.InputView;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class GameFactoryTest {

    private GameFactory gameFactory;
    private static final int TRYNUM = 3;
    private static final int CARNUM = 4;
    private ArrayList<Integer> inputs;

    @BeforeEach
    void setUp(){
        gameFactory = new GameFactory();
        inputs = new ArrayList<>();
        inputs.add(CARNUM);
        inputs.add(TRYNUM);
    }

    @Test
    @DisplayName("Car의 생성 주관을 GameFactory에서 하는 테스트")
    void buildCar(){
        Car car = gameFactory.car();
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car).extracting("random")
                .hasOnlyElementsOfType(Random.class);
    }


    @Test
    @DisplayName("Cars 생성을 GameFactory에서 주관하여 Car의 생성과 Cars의 생성을 통합테스트")
    void buildCars(){
        Cars cars = gameFactory.cars(CARNUM);
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("Game의 생성을 GameFactory에서 주관하여 Game, Cars, Car의 생성을 통합테스트")
    void buildGame(){
        MockedStatic<InputView> inputView = mockStatic(InputView.class);
        when(InputView.input(Game.strs))
                .thenReturn(inputs);
        assertThat(gameFactory.game()).isInstanceOf(Game.class);
        inputView.close();
    }
}

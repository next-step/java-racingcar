package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
        assertThat(car).hasNoNullFieldsOrProperties();
    }


    @Test
    @DisplayName("Cars 생성을 GameFactory에서 주관하여 Car의 생성과 Cars의 생성을 통합테스트")
    void buildCars(){
        Cars cars = gameFactory.cars(CARNUM, TRYNUM);
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars).hasNoNullFieldsOrProperties();
        assertThat(cars).hasFieldOrPropertyWithValue("tryNum",TRYNUM);
        assertThat(cars.getCars()).isInstanceOf(List.class).hasSize(CARNUM);
    }

    @Test
    void buildGame(){
        MockedStatic<InputView> inputView = mockStatic(InputView.class);
        when(InputView.input(Game.strs))
                .thenReturn(inputs);
        assertThat(gameFactory.game()).isInstanceOf(Game.class);
        inputView.close();
    }
}

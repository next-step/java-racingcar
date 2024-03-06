package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarRacingGameTest {
    RandomGenerator generator ;
    CarRacingGame carRacingGame;

    @BeforeEach
    void setUp(){
        generator = mock(RandomGenerator.class);
        when(generator.generate()).thenReturn(4);

        carRacingGame = new CarRacingGame(generator);
        carRacingGame.createCarList(3);
    }

    @Test
    @DisplayName("입력 받은 자동차수 크기의 리스트를 만든다.")
    public void givenCarCountThenCreateCarList(){
        assertThat(carRacingGame.cars.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("자동차가 예상대로 전진했는지 확인한다.")
    public void verifyCarsFinalPosition(int index) throws Exception{
        when(generator.generate()).thenReturn(4);

        carRacingGame.carRacing(3);
        assertThat(carRacingGame.cars.get(index).getPosition()).isEqualTo(3);
    }
}

package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.CarRacing;
import step3.model.Car;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarRacingTest {

    @Test
    @DisplayName("난수 생성 테스트")
    public void createRandom(){
        final int BIG_NUMBER = 10000;
        CarRacing car = new CarRacing();

        for(int i=0; i< BIG_NUMBER;i++ ){
            assertThat(car.createRandom(new Random())).isBetween(0,9);
        }
    }

    @Test
    @DisplayName("난수 Mock 테스트 ")
    public void createRandom2(){
        //given
        Random random = mock(Random.class);
        when(random.nextInt()).thenReturn(5);
        CarRacing carRacing = new CarRacing(3,3);

        //when
        int result = carRacing.createRandom(random);
        Car car =  new  Car();
        car.move(result);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("numofcar_인풋에러")
    void checkCars(){
        assertThatThrownBy(()->{
            new CarRacing(0,5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numofcar_인풋에러");
    }

    @Test
    @DisplayName("numoftry_인풋에러")
    void checkTries(){
        assertThatThrownBy(()->{
            new CarRacing(3,0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numoftry_인풋에러");
    }
}

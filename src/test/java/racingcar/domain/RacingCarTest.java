package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.RacingCarGame;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void racing() {
        String[] carNames = "aa,bb,cc,dd".split(",");
        int numTry = 6;
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    }

    @DisplayName("테스트 ")
    @Test
    void racing2() {
        String[] carNames = "aa,bb,cc,dd".split(",");
        int numTry = 6;
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    }

    @DisplayName("자동차는 이름을 가진다 ")
    @ValueSource(strings = {"rock" , "하하"})
    @ParameterizedTest
    public  void name(String name ){
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
    
    @DisplayName("자동차의 초기 위치는 0이다  ")
    @Test
    void default_position(){
         Car car = new Car("jason");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다")
    @Test
    void current_position(){
        Car car = new Car("jason",10);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차가 이동한다 ")
    @Test
    void move(){
        Car car = new Car("jason"){
            @Override
            protected  int getRandom(){
                return 5;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @DisplayName("자동차가 4미만일때 정지한다. ")
    @ValueSource(ints = {1 , 2})
    @ParameterizedTest
    void stop(final int conditions){
        Car car = new Car("jason");
        car.move(conditions);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}




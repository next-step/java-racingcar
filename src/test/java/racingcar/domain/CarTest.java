package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @DisplayName("자동차는 이름을 가진다 ")
    @ValueSource(strings = {"jason" , "박재성"})
    @Test
    public  void name(final String name ){
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);

    }

    @Test
    public  void name2(final String name ){
        final Car car = new Car(name);
      //  assertThatExceptionOfType()

    }

    @DisplayName("자동차의 초기 위치는 0이다  ")
    @Test
    void default_position(){
        final Car car = new Car("jason");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다")
    @Test
    void current_position(){
        final Car car = new Car("jason",10);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차가 이동한다 ")
    @Test
    void move(){
        final Car car = new Car("jason"){
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
    @Test
    void stop(final int conditions){
        final Car car = new Car("jason");
        car.move(conditions);
        assertThat(car.getPosition()).isEqualTo(0);
    }



}

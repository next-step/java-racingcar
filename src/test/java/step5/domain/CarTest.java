package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class CarTest {

    @DisplayName("자동차 이름넣어서 생성")
    @Test
    void createCarWithNameTest(){
        String name = "first";
        Car car = Car.from(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름, 위치 넣어서 생성")
    @Test
    void createCarWithNameAndPositionTest(){
        String name = "first";
        int position = 10;

        Car car = Car.of(name, position);

        assertThat(car.getPosition()).isEqualTo(position);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 대소비교 (position 으로 대소비교)")
    @Test
    void compareCarsByPositionTest(){
        Car car1 = Car.of("car1",10);
        Car car2 = Car.of("car2",5);
        Car car3 = Car.of("car3",5);

        assertThat(car1.compareTo(car2) > 0).isTrue();
        assertThat(car2.compareTo(car3) == 0).isTrue();
        assertThat(car2.compareTo(car1) < 0).isTrue();
    }

    @DisplayName("자동차 출력 확인")
    @Test
    void toStringTest(){
        Car car1 = Car.of("car1",5);
        assertThat(car1.toString()).isEqualTo("car1 : -----");
    }

    @DisplayName("자동차 이름 5글자 초과시 에러 발생")
    @Test
    void carNamingExceptionTest(){
        assertThatIllegalStateException().isThrownBy(
                ()->Car.from("123456")
        ).withMessageContaining("5글자 이하");
    }

    @DisplayName("입력받은 boolean 따라 차가 움직인다.")
    @Test
    void moveCarTest(){
        Car car = Car.from("car1");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
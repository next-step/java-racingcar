package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @ParameterizedTest(name = "자동차 이름은 5자를 초과할 수 없다")
    @ValueSource(strings = {"abcdefg", "abcdefgh"})
    void test1(String carName){
        assertThatIllegalArgumentException()
                .isThrownBy(()->new Car(carName));
    }

    @ParameterizedTest(name = "각 자동차에 이름을 부여할 수 있다")
    @ValueSource(strings = {"abc", "abcd"})
    void test2(String carName){
        Car car = new Car(carName);
        assertThat(carName).contains(car.getName());

    }

    @ParameterizedTest(name = "전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다")
    void test3(String carName){

    }

    @ParameterizedTest(name = "자동차 이름은 쉼표(,)를 기준으로 구분한다")
    @ValueSource(strings = {"ab,abc,abcd"})
    void test4(String carName){
        assertThat(carName.split(",")).contains("ab", "abc", "abcd");
    }


    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    void test5(){

    }

    @Test
    @DisplayName("우승자는 한명 이상일 수 있다")
    void test6(){
        //given
        Car a = new Car("a", 1);
        Car b = new Car("b", 2);
        Car c = new Car("c", 2);
        List<Car> carList = Arrays.asList(a, b, c);
        System.out.println("carList = " + carList);


        //when
        Cars cars = new Cars(carList);
        List<Car> winners = cars.findWinners(carList);
        System.out.println("winners = " + winners);

        //then
        assertThat(winners).contains(b,c);
    }


}
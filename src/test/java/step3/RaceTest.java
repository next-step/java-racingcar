package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.object.Car;
import step3.util.MovableNumberGenerator;
import step3.util.NonMovableNumberGenerator;
import step3.util.NumberGenerator;
import step3.util.StringSplitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {


    //    초간단 자동차 경주 게임을 구현한다.
//    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//    사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//    전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
//    자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

    @ParameterizedTest
    @DisplayName("자동차 움직임 테스트 (4 이상만 전진)")
    @CsvSource(value = {"0,1", "7,2", "9,2"}, delimiter = ',')
    void moveTest(int chance, int expected){
        Car car = new Car();
        car.move(chance);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

//    @ParameterizedTest
//    @DisplayName("자동차 생성 테스트")
//    @ValueSource(ints = {1, 4, 10})
//    void generateCarArrayTest(int carCount){
//        Race race = new Race();
//        List<Car> actual = race.generateCarList(carCount);
//        assertThat(actual).hasSize(carCount);
//    }

    //step 4
    @Test
    @DisplayName("자동차 생성 테스트")
    void generateCarListTest(){
        step3.Race race = new step3.Race();
        List<String> value = List.of("lee", "park", "kim");
        List<Car> actual = race.generateCarList(value);
        int expected = 3;
        assertThat(actual).hasSize(expected);
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    void stayIfNumberIstSmallerThanFour() {
        // Given
        final Car car = new Car();
        final NumberGenerator numberGenerator = new NonMovableNumberGenerator();
        int expected = car.getPosition();
        // When
        car.move(numberGenerator.generate());
        int actual = car.getPosition();
        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 4보다 크면 전진")
    @Test
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car car = new Car();
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        int expected = car.getPosition() + 1;
        // When
        car.move(numberGenerator.generate());
        int actual = car.getPosition();
        // Then
        assertThat(actual).isEqualTo(expected);
    }


    //step 4
//    각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
//    전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
//    자동차 이름은 쉼표(,)를 기준으로 구분한다.
//    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    @Test
    @DisplayName("쉼표(,)를 가진 문자열을 통해 이름 개수 테스트")
    void getNameListTest() {
        String value = "lee,kim,park";
        StringSplitter stringSplitter = new StringSplitter();
        List<String> actual = stringSplitter.getNameList(value);
        String expectedName1 = "lee";
        String expectedName2 = "kim";
        String expectedName3 = "park";
        assertThat(actual).contains(expectedName1, expectedName2, expectedName3);
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinnerListTest() {

        Car leeCar = new Car("lee", 5);
        Car parkCar = new Car("park", 4);
        Car kimCar = new Car("kim", 5);
        List<Car> value = List.of(
                leeCar,
                parkCar,
                kimCar);

        step3.Race race = new step3.Race();
        List<Car> actual = race.findWinnerList(value);
        assertThat(actual).containsExactlyInAnyOrder(leeCar, kimCar);
    }

}

package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    @ParameterizedTest
    @DisplayName("차량 이동 조건 메소드 체크 : 랜덤 숫자가 4 이상이면(True) 전진or멈춤 조건 메소드 정상 작동하는지 테스트")
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveConditionMethodTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        assertThat(mockRandomGenerator.isCarMoveCondition()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("차량 이동 조건 메소드 실패 체크 : 랜덤 숫자가 4 미만이면 전진or멈춤 조건 메소드 실패하는지 테스트")
    @ValueSource(ints = {1,2,3})
    public void moveConditionMethodFailTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        assertThat(mockRandomGenerator.isCarMoveCondition()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("조건 충족시 차량 포지션 증가 체크 : ")
    @ValueSource(ints = {4,5,6,7,8,10})
    void moveMethodTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        Car car = new Car("랜덤카").move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("조건 미충족시 차량 포지션 증가 실패 체크 : ")
    @ValueSource(ints = {1,2,3})
    void moveMethodFailTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        Car car = new Car("랜덤카").move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자 생성자에 빈값 입력시 예외 발생 체크 메소드")
    void championValidateTest(){
        assertThatThrownBy(() ->{
            List<Round> rounds = new ArrayList<>();
           new Champion(rounds);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("우승자 결정 메소드 테스트")
    @MethodSource("mockArrivedCars")
    void getChampionMethodTest(List<Car> cars, String expected){

        List<Round> lastRound = new ArrayList<>();
        lastRound.add(new Round(cars));

        assertThat(new Champion(lastRound).getChampitions()
                                          .stream()
                                          .map(value -> value.toString())
                                          .collect(Collectors.joining(","))
                                         ).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("우승자 포지션 결과값 가져오는 테스트")
    @MethodSource("mockArrivedCarsPosition")
    void getChampionPositionMethodTest(List<Car> cars, int expected){

        List<Round> lastRound = new ArrayList<>();
        lastRound.add(new Round(cars));

       assertThat(new Champion(lastRound).maxCarPostion(cars))
                                         .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("우승자 결정 메소드에 빈 라운드 리스트 입력시 예외 발생 테스트")
    @MethodSource("mockNullArrivedCars")
    void getChampionMethodFailTest(List<Car> cars, String expected){

        List<Round> lastRound = new ArrayList<>();
        assertThatThrownBy(() ->{
            new Champion(lastRound).getChampitions()
                                   .stream()
                                   .map(value -> value.toString())
                                   .collect(Collectors.joining(","));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> mockArrivedCars(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("자동차1", 3));
        cars.add(new Car("자동차2", 5));
        cars.add(new Car("자동차3", 6));
        cars.add(new Car("자동차4", 6));
        cars.add(new Car("자동차5", 7));

        List<Car> cars2 = new ArrayList<>();
        cars2.add(new Car("자동차1", 3));
        cars2.add(new Car("자동차2", 5));
        cars2.add(new Car("자동차3", 8));
        cars2.add(new Car("자동차4", 6));
        cars2.add(new Car("자동차5", 7));

        List<Car> cars3 = new ArrayList<>();
        cars3.add(new Car("자동차1", 3));
        cars3.add(new Car("자동차2", 5));
        cars3.add(new Car("자동차3", 9));
        cars3.add(new Car("자동차4", 9));
        cars3.add(new Car("자동차5", 7));

        return   Stream.of(
                Arguments.of(cars, "자동차5"),
                Arguments.of(cars2, "자동차3"),
                Arguments.of(cars3, "자동차3,자동차4")
        );
    }

    private static Stream<Arguments> mockNullArrivedCars(){
        List<Car> cars = new ArrayList<>();
        List<Car> cars2 = new ArrayList<>();
        List<Car> cars3 = new ArrayList<>();

        return   Stream.of(
                Arguments.of(cars, "자동차5"),
                Arguments.of(cars2, "자동차3"),
                Arguments.of(cars3, "자동차3,자동차4")
        );
    }

    private static Stream<Arguments> mockArrivedCarsPosition(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("자동차1", 3));
        cars.add(new Car("자동차2", 5));
        cars.add(new Car("자동차3", 6));
        cars.add(new Car("자동차4", 6));
        cars.add(new Car("자동차5", 7));

        List<Car> cars2 = new ArrayList<>();
        cars2.add(new Car("자동차1", 3));
        cars2.add(new Car("자동차2", 5));
        cars2.add(new Car("자동차3", 8));
        cars2.add(new Car("자동차4", 6));
        cars2.add(new Car("자동차5", 7));

        List<Car> cars3 = new ArrayList<>();
        cars3.add(new Car("자동차1", 3));
        cars3.add(new Car("자동차2", 5));
        cars3.add(new Car("자동차3", 9));
        cars3.add(new Car("자동차4", 9));
        cars3.add(new Car("자동차5", 7));

        return   Stream.of(
                Arguments.of(cars, 7),
                Arguments.of(cars2, 8),
                Arguments.of(cars3, 9)
        );
    }
}

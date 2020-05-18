package study.step3;

<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
=======
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
<<<<<<< HEAD

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
=======
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844


public class RacingGameTest {

<<<<<<< HEAD
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
        Car car = new Car().move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("조건 미충족시 차량 포지션 증가 실패 체크 : ")
    @ValueSource(ints = {1,2,3})
    void moveMethodFailTest(int number){
        CarMoveCondition mockRandomGenerator = new MockRandomCarMoveCondition(number);
        Car car = new Car().move(mockRandomGenerator);
        assertThat(car.getCarPosition()).isEqualTo(0);
=======
    private RacingGame racingGame;

    @ParameterizedTest
    @DisplayName("차량 수 : 차량 대수 지정한 대로 셋팅되어 게임되는지 테스트")
    @ValueSource(strings = {"1","2","3","4","5","6","7","8","110","350"})
    public void numberOfVehicleTest(String carNumbers){
        racingGame = new RacingGame.RacingGameBuilder()
                .setCarNumbers(carNumbers)
                .setTime("4")
                .build();

        List<Car> cars = racingGame.gameStart();
        assertThat(cars.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("지정한 시도 수 : 지정한 시도 횟수 대로 셋팅되어 게임되는지 테스트")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,110,350})
    public void numberOfTryTest(int tryNum){
        Car car = new Car("1");
        car.move(tryNum);
        assertThat(car.rounds()).isEqualTo(tryNum);
    }

    @ParameterizedTest
    @DisplayName("랜덤 숫자체크 : 랜덤 숫자가 4 이상이면(True) 전진or멈춤 체크 메소드 정상 작동하는지 테스트")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    public void randomNumberTest(int number){
        Car car = new Car("1");
        RandomGenerator mockRandomGenerator = new MockRandomGenerator(number);
        assertThat(car.goOrStop(mockRandomGenerator.getRandomInt())).isTrue();
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력시 벨리데이션 체크 : 숫자 아닌 문자, 빈문자열 넣으면 Exception 출력 하는지 테스트")
<<<<<<< HEAD
    @ValueSource(strings = {""," ","ㅇㅇ"})
    void validatorTest(String numberString){
        assertThatThrownBy(() ->{
            new RacingGame(Integer.parseInt(numberString), Integer.parseInt(numberString));
=======
    @ValueSource(strings = {""," ","3","43","ㅇㅇ"})
    void validatorTest(String numberString){
        assertThatThrownBy(() ->{
            racingGame = new RacingGame.RacingGameBuilder()
                    .setCarNumbers(numberString)
                    .setTime("4")
                    .build();

>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

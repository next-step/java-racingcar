package racing.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.strategy.DefaultMoveStategy;
import racing.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    public racing.RacingCars racingCars;

    @DisplayName("이름배열을 받아 이름을 가진 레이싱카 리스트 생성")
    @ParameterizedTest
    @MethodSource("getNameOfCarList")
    public void 레이싱카_리스트_생성_테스트_길이(String[] input, int expected) {
        assertThat(racingCars.of(input).getRecingCarList()).hasSize(expected);
    }


    @DisplayName("이름배열을 받아 이름을 가진 레이싱카 리스트 생성")
    @ParameterizedTest
    @MethodSource("getNameOfCarList")
    public void 레이싱카_리스트_생성_테스트_실제객체존재여부(String[] input) {
        MoveStrategy strategy = new DefaultMoveStategy();
        assertThat(racing.RacingCars.of(input).getRecingCarList()).extracting("nameOfCar", String.class)
                .contains(input);
    }


    @DisplayName("레이싱카의 레이싱 시작(파라미터 : 이동횟수)")
    @ParameterizedTest
    @MethodSource("getNameOfCarListWithCountOfRacing")
    public void 레이싱카리스트_레이싱시작_처리_테스트(String[] input, int countOfRacing, int expected) {
        MoveStrategy strategy = new DefaultMoveStategy();
        racingCars = racing.RacingCars.of(input);
        racingCars.startRacing(countOfRacing, strategy);

        racingCars.getRecingCarList().stream().
                forEach(
                        car -> assertThat(car.getRacingResult()).isEqualTo(expected)
                );

    }


    @Ignore
    @DisplayName("자동차 갯수 구하기")
    @ParameterizedTest
    @MethodSource("getNameOfCarList")
    public void 레이싱카리스트에서_자동차갯수_구하기(String[] input, int excpected) {

        racingCars = racing.RacingCars.of(input);
        assertThat(racingCars.getCountOfRacingCar()).isEqualTo(excpected);
    }



    @DisplayName("우승자 가져오기")
    @ParameterizedTest
    @MethodSource("getNameOfCarListWithWinner")
    public void 우승자_가져오기(String[] input, int countOfRacing, String[] excpected) {
        MoveStrategy strategy = new DefaultMoveStategy();
        racingCars = RacingCars.of(input);
        racingCars.startRacing(countOfRacing, strategy);
        assertThat(racingCars.getCarsOfWinnerName()).isEqualTo(Arrays.asList(excpected));
    }



    static Stream<Arguments> getNameOfCarList() {
        return Stream.of(
                Arguments.of(new String[]{"조경현", "에디", "자바지기"}, 3),
                Arguments.of(new String[]{"1번차", "2번차", "3번차", "4번차"}, 4)
        );
    }

    static Stream<Arguments> getNameOfCarListWithCountOfRacing() {
        return Stream.of(
                Arguments.of(new String[]{"조경현", "에디", "자바지기"}, 1, 1),
                Arguments.of(new String[]{"1번차", "2번차", "3번차", "4번차"}, 3, 3)
        );
    }

    static Stream<Arguments> getNameOfCarListWithWinner() {
        return Stream.of(
                Arguments.of(new String[]{"조경현", "에디", "자바지기"}, 1, new String[]{"조경현", "에디", "자바지기"}),
                Arguments.of(new String[]{"1번차", "2번차", "3번차", "4번차"}, 3, new String[]{"1번차", "2번차", "3번차", "4번차"})
        );
    }


}

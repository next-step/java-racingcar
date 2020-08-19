package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.strategy.DefaultMoveStategy;
import racing.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarListTest {
    public RacingCarList racingCarList;

    @DisplayName("이름배열을 받아 이름을 가진 레이싱카 리스트 생성")
    @ParameterizedTest
    @MethodSource("getNameOfCarList")
    public void 레이싱카_리스트_생성_테스트_길이(String[] input, int expected) {
        MoveStrategy strategy = new DefaultMoveStategy();
        assertThat(RacingCarList.setRacingCars(input, strategy)).hasSize(expected);
    }


    @DisplayName("이름배열을 받아 이름을 가진 레이싱카 리스트 생성")
    @ParameterizedTest
    @MethodSource("getNameOfCarList")
    public void 레이싱카_리스트_생성_테스트_실제객체존재여부(String[] input) {
        MoveStrategy strategy = new DefaultMoveStategy();
        assertThat(RacingCarList.setRacingCars(input, strategy)).extracting("nameOfCar", String.class)
                                                                .contains(input);
    }

    @DisplayName("레이싱카의 레이싱 시작(파라미터 : 이동횟수)")
    @ParameterizedTest
    @MethodSource("getNameOfCarListWithCountOfRacing")
    public void 레이싱카리스트_레이싱시작_처리_테스트(String[] input, int countOfRacing, Integer[] expected) {
        MoveStrategy strategy = new DefaultMoveStategy();
        racingCarList = new RacingCarList(RacingCarList.setRacingCars(input, strategy));
        racingCarList.startRacing(countOfRacing);

        racingCarList.getRecingCarList().stream().
                                         forEach(
                                                 car -> assertThat(car.racingResult).isEqualTo(expected)
                                         );

    }

    static Stream<Arguments> getNameOfCarList() {
        return Stream.of(
                Arguments.of(new String[]{"조경현", "에디", "자바지기"}, 3),
                Arguments.of(new String[]{"1번차", "2번차", "3번차", "4번차"}, 4)
        );
    }

    static Stream<Arguments> getNameOfCarListWithCountOfRacing() {
        return Stream.of(
                Arguments.of(new String[]{"조경현", "에디", "자바지기"}, 1, new Integer[]{1}),
                Arguments.of(new String[]{"1번차", "2번차", "3번차", "4번차"}, 3, new Integer[]{1, 1, 1})
        );
    }


}

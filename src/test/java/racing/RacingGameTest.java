package racing;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.strategy.DefaultMoveStategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    static RacingGame racingGame;

    @BeforeEach
    public  void setUp() {
        racingGame = new RacingGame();
    }

    @DisplayName("레이싱게임 시작")
    @ParameterizedTest
    @CsvSource(value={"3:3","4:4"}, delimiter = ':')
    public void 레이싱게임준비(int countOfRacingCar, int expectedSize) {
        assertThat(racingGame.setRacing(countOfRacingCar)).hasSize(expectedSize);
    }

    @DisplayName("레이싱게임 시작")
    @ParameterizedTest
    @MethodSource("getRacingGameParamter")
    //이부분 값 테스트가 제대로 되지 않네요... 값은 같은데 Integer라 객체의 참조주소를 비교하는 거 같습니다.
    //어떤게 테스트를 통과할 수 있을까요? 테스트 케이스가 문제네요...
    public void 레이싱게임시작(int countOfRacing, ArrayList<RacingCar> racingCarList, ArrayList<Integer[]> expected) {
        assertThat(racingGame.startRacing(countOfRacing, racingCarList)).extracting("racingResult").isEqualTo(expected);
    }


    static Stream<Arguments> getRacingGameParamter() {
        DefaultMoveStategy defaultMoveStategy = new DefaultMoveStategy();
        RacingCar beforeMoveCar = new RacingCar(defaultMoveStategy);



        return Stream.of(
                Arguments.of(4, new ArrayList<RacingCar>(Arrays.asList(beforeMoveCar, beforeMoveCar, beforeMoveCar)), new ArrayList<Integer[]>(Arrays.asList(new Integer[]{1, 1, 1, 1},new Integer[]{1, 1, 1, 1}, new Integer[]{1, 1, 1, 1}))),
                Arguments.of(3, new ArrayList<RacingCar>(Arrays.asList(beforeMoveCar, beforeMoveCar, beforeMoveCar, beforeMoveCar)), new ArrayList<Integer[]>(Arrays.asList(new Integer[]{1, 1, 1},new Integer[]{1, 1, 1}, new Integer[]{1, 1, 1}, new Integer[]{1, 1, 1}))),
                Arguments.of(2, new ArrayList<RacingCar>(Arrays.asList(beforeMoveCar, beforeMoveCar, beforeMoveCar, beforeMoveCar)), new ArrayList<Integer[]>(Arrays.asList(new Integer[]{1, 1}, new Integer[]{1, 1})))
        );
    }


}

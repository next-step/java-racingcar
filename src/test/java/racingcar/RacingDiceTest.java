package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.race.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class RacingDiceTest {

    @DisplayName("10 이하의 랜덤 수가 정상적으로 나오는 지 테스트")
    @ParameterizedTest
    @MethodSource("getGenerateNumbers")
    public void generateTest(Integer number){
        if(number  > RacingDice.RACING_MAX_BOUND) {
            Assertions.fail("A number less than " + RacingDice.RACING_MAX_BOUND + " should come out.");
        }
    }

    public static Stream<Arguments> getGenerateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Dice dice = RacingDice.newInstance();
        for(int i = 0 ; i < 100 ; i++) {
            numbers.add(dice.generate());
        }
       return numbers.stream().map(Arguments::of);
    }

}
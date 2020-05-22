package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class RacingDiceTest {

    private final RacingDice DEFAULT_RACING_DICE = RacingDice.newInstance();

    @DisplayName("10 이하의 랜덤 수가 정상적으로 나오는 지 테스트 case 1")
    @Test
    public void generateTest_1(){
        for(int i = 0 ; i < 1000 ; i++){
            int generatedValue = DEFAULT_RACING_DICE.generate();

            Assertions.assertThat(generatedValue < RacingDice.RACING_MAX_BOUND).isTrue();
        }
    }

    @DisplayName("10 이하의 랜덤 수가 정상적으로 나오는 지 테스트 case 2")
    @ParameterizedTest
    @MethodSource("getGenerateNumbers")
    public void generateTest_2(int generatedValue){
         Assertions.assertThat(generatedValue < RacingDice.RACING_MAX_BOUND).isTrue();
    }

    public static Stream<Arguments> getGenerateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Dice dice = RacingDice.newInstance();
        for(int i = 0 ; i < 1000 ; i++) {
            numbers.add(dice.generate());
        }
       return numbers.stream().map(Arguments::of);
    }

}
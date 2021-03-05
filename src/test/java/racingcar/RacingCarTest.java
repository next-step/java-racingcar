package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGameRule;
import racingcar.domain.RacingCarList;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    private RacingCarGameRule createRacingCarGameRuleWithFixedMovingStrategy(boolean movable) {
        return new RacingCarGameRule(() -> movable);
    }

    private String createSampleCarNameWithLength(int length) {
        String character="a";
        StringBuilder nameBuilder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            nameBuilder.append(character);
        }
        return nameBuilder.toString();
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일시 예외 발생 테스트")
    void carNameWithLongerThanLimit() {
        int maxLength=5;
        int lengthToCreate=maxLength+1;
        String carName=createSampleCarNameWithLength(lengthToCreate);

        assertThat(carName.length()).isEqualTo(lengthToCreate);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new RacingCar(new RacingCarGameRule(),carName));
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1","true:1","false:0"}, delimiter = ':')
    @DisplayName("자동차 move 테스트")
    void move(boolean movable, int expectedTravelDistance) {
        String SampleCarName="test";
        RacingCar test = new RacingCar(createRacingCarGameRuleWithFixedMovingStrategy(movable),SampleCarName);
        test.move();
        assertThat(test.getTravelledDistance()).isEqualTo(expectedTravelDistance);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1","false:0"}, delimiter = ':')
    @DisplayName("자동차 리스트 move 테스트")
    void moveList(boolean movable,int expectedTravelDistance) {
        String[] sampleCarNameArray = {"abc", "ddd", "efg"};
        RacingCarList racingCarList = new RacingCarList(createRacingCarGameRuleWithFixedMovingStrategy(movable), sampleCarNameArray);
        racingCarList.move();
        racingCarList.getIndividualScore()
                .forEach(carScore ->
                assertThat(carScore.getTravelledDistance()).isEqualTo(expectedTravelDistance)
        );
    }
}

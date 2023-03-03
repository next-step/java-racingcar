package car;

import car.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    List<Car> participants;

    @BeforeEach
    void setUp() {
        participants = new ArrayList<>();
        participants.add(new Car("씽씽카", 3));
        participants.add(new Car("쏘카", 1));
        participants.add(new Car("그린카", 3));
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,현대자동차"}, delimiter = ',')
    void 이름을_기진_자동차_객체를_생성한다(String successCase, String failCase) {
        // then
        Car car = new Car(successCase);

        assertThatThrownBy(() -> new Car(failCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 미만만 가능 합니다. name = " + failCase);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차_이름은_쉼표구분자로_구분한다(String carName) {
        //when
        String[] carNames = carName.split(",");

        //then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("0과 9사이의 무작위 수를 반환한다")
    void shouldBeReturnBetweenZeroAndNineByRandom() {

        //when
        int randomValue = RandomUtils.generateRandomValue();

        //then
        assertThat(randomValue).isLessThan(10);
    }

    @Test
    void 전진하는_자동차의_이름를_같이_출력한다() {
        participants.forEach(Car::printPositionStatus);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:5"}, delimiter = ':')
    void 자동차_이름과_이동횟수를_입력한다(String carName, int count) {
        String[] carNames = carName.split(",");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 자동차_전진횟수를_최댓값을_구한다() {
        //when
        int actual = getMaxPosition(participants);

        //then
        assertThat(actual).isEqualTo(3);
     }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // when
        List<Car> winners = getWinners(participants);

        // then
        System.out.println("최종 우승자: " + winners);
        assertThat(winners).hasSize(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,소카,그린카:5"}, delimiter = ':')
    void 자동차_경주_게임을_시작한다(String carNames, int count) {

        //given
        String[] cars = carNames.split(",");
        List<Car> participants = new ArrayList<>();

        for (String carName : cars) {
            participants.add(new Car(carName));
        }

        //when
        List<Car> winners = play(participants, count);
        System.out.println("Winner: " + winners);
     }

    private List<Car> getWinners(List<Car> participants) {
        List<Car> winners = new ArrayList<>();
        int max = getMaxPosition(participants);

        for (Car car : participants) {
            if (max == car.getPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> participants) {
        int max = 0;

        for (Car car : participants) {
            if (max <= car.getPosition()) {
                max = car.getPosition();
            }
        }

        return max;
    }

    private List<Car> play(List<Car> participants, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            participants.forEach(participant -> {
                int randomValue = RandomUtils.generateRandomValue();
                participant.move(randomValue);
            });
            System.out.println();
        }

        return getWinners(participants);
    }
}

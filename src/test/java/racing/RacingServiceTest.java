package racing;

import exception.CarLocationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Location;
import util.RacingValidator;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    @Test
    @DisplayName("자동차가 1칸 앞으로 전진한다.")
    void 자동차_전진_테스트() throws CarLocationException {
        Integer location = 0;
        Car car = new Car("hbae", new Location(location));
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        assertThat(car.moveForward(randomNumber)).isEqualTo(new Location(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 숫자는 전진할 수 있음을 확인한다.")
    void 전진_가능_테스트(int input) {
        assertThat(RacingValidator.isMovable(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4미만의 숫자는 전진할 수 없음을 확인한다.")
    void 전진_불가능_테스트(int input) {
        assertThat(RacingValidator.isMovable(input)).isFalse();
    }

    @Test
    @DisplayName("자동차 우승을 가리기 위해 최대 이동거리를 구하는 테스트를 수행한다.")
    void 리스트들중_최대_숫자구하기_테스트() {
        List<Integer> numList = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int randomNumber = RandomNumberGenerator.getRandomNumber();
            maxValue = Math.max(maxValue, randomNumber);
            numList.add(randomNumber);
        }
        assertThat(maxValue).isEqualTo(getMaxNumberOfList(numList));
    }

    private int getMaxNumberOfList(List<Integer> numList) {
        return numList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }


}

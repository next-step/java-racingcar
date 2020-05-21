package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupsTest {

    @DisplayName("CarGroups 일급 컬렉션 생성 테스트 (CarFactory를 이용)")
    @ParameterizedTest
    @MethodSource("mockCarNamesBuilder")
    public void getNewCarGroupUsingCarFactory(String[] carNames) {
        CarGroups racingCars = new CarGroups(CarFactory.makeCars(carNames));
        int carCounts = carNames.length;

        assertThat(racingCars.getCarGroups().size())
                .isEqualTo(carCounts);
        // CarGroups 일급 컬렉션 내부의 List<Car>의 초기 position값 0을 확인하는 테스트
        // 반복문을 사용하지 않고 map으로 list화해서 테스트 해보기
        // 이름 테스트 또한 진행
    }

    private static Stream<Arguments> mockCarNamesBuilder() {
        return Stream.of(
                Arguments.of(
                       new String[]{"a", "b", "c", "d", "e"},
                       new String[]{"java", "js", "python", "go"},
                       new String[]{"tdd", "cleanCode"}
                )
        );
    }
}

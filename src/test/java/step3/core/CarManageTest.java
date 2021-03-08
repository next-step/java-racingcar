package step3.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.Car;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 관리 클래스 테스트
 */
class CarManageTest {

    private static Stream<Arguments> getCarManagement() {
        return Stream.of(
                Arguments.of(new CarManage(3), 3),
                Arguments.of(new CarManage(4), 4)
        );
    }

    @DisplayName("자동차 관리 클래스의 자동차 생성 테스트")
    @ParameterizedTest(name = "CarManage 클래스로 Car 생성된 인스턴스 갯수: {1}")
    @MethodSource("getCarManagement")
    void testCase1(CarManage given, int carSize) {
        // given

        // when
        List<Car> cars = given.getCars();
        // then
        assertThat(cars.size()).isEqualTo(carSize);
    }

}

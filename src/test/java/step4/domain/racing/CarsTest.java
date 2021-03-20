package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Car;
import step4.domain.car.position.Position;
import step4.domain.ipnut.InputNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("Cars 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        InputNames inputNames = new InputNames("a,b,c");

        // when
        Cars actualCars = new Cars(inputNames);
        Cars expectedCars = new Cars(inputNames);

        // then
        assertThat(actualCars).isEqualTo(expectedCars);

    }

    @DisplayName("Cars 인스턴스 부적절한 값 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {

        // given
        List<Car> cars = null;

        // when and then
        assertThatThrownBy(() -> {
            new Cars(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

    }

    @DisplayName("Cars 인스턴스 이동 및 상태 여부 테스트")
    @Test
    void 이동() {
        // given
        InputNames inputNames = new InputNames("a,b,c");
        Cars expectedCars = new Cars(inputNames);
        expectedCars.move(() -> true);  // 모두 한 칸 씩 이동했다는 가정이므로 given 에 넣었습니다.

        // when
        Cars actualCars = new Cars(inputNames);
        actualCars.move(() -> true);

        // then
        assertThat(actualCars).isEqualTo(expectedCars);
    }

    @DisplayName("Cars 인스턴스 소유한 여러 Car 중에서 최대값 반환 테스트")
    @Test
    void 최대값_반환() {
        // given
        Position expectedPosition = new Position(1);

        InputNames inputNames = new InputNames("a,b,c");
        Cars cars = new Cars(inputNames);


        // when
        cars.move(() -> true);
        Position actualPosition = cars.maxPosition();

        // then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("Cars 인스턴스 소유한 여러 Car 중에서 우승자 리스트 반환 테스트")
    @Test
    void 우승자_반환() {
        // given
        Cars cars = new Cars("a,b,c");
        List<Car> expected = cars.cars();

        // when
        cars.move(() -> true);
        Position winnerPosition = cars.maxPosition();

        List<Car> actual = cars.winners(winnerPosition);

        // then
        assertThat(actual).isEqualTo(expected);
    }


}
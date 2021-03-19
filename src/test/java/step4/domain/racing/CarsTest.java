package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Car;
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
        Cars cars = new Cars(inputNames);

        // then
        assertThat(cars).isNotNull();

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
        Cars cars = new Cars(inputNames);

        // when
        cars.move(() -> true);
        List<Car> carList = cars.cars();

        carList.stream()
                .map(car -> car.position())
                .map(position -> position.position())
                .forEach(actual -> {
                            assertThat(actual).isEqualTo(1);
                        }
                );
    }

    @DisplayName("Cars 인스턴스 소유한 여러 Car 중에서 최대값 반환 테스트")
    @Test
    void 최대값_반환(){
        // given
        InputNames inputNames = new InputNames("a,b,c");
        Cars cars = new Cars(inputNames);

        // when
        cars.move(()-> true);
        int actual = cars.maxPosition();

        // then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("Cars 인스턴스 소유한 여러 Car 중에서 우승자 리스트 반환 테스트")
    @Test
    void 우승자_반환(){
        // given
        InputNames inputNames = new InputNames("a,b,c");
        Cars cars = new Cars(inputNames);

        // when
        List<Car> expected = cars.cars();
        expected.stream().forEach(car -> car.move(()-> true));
        int winnerPosition = expected.stream()
                .mapToInt(car -> car.position().position())
                .max()
                .orElseGet(()->0);

        List<Car> actual = cars.winners(winnerPosition);

        // then
        assertThat(actual).isEqualTo(expected);
    }



}
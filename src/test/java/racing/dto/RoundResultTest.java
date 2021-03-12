package racing.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.ReadonlyCar;

class RoundResultTest {

    @Test
    @DisplayName("자동차 목록을 반환한 이후, 업데이트 되어도 이전 결과에 영향을 주면 안된다.")
    void returnImmutableWinnerList() {
        Car car = new Car(() -> 1, "test");
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        RoundResult roundResult = new RoundResult(carList);
        List<ReadonlyCar> firstCarList = roundResult.getCarList();

        Car car2 = new Car(() -> 1, "test2");
        firstCarList.add(car2);

        List<ReadonlyCar> secondCarList = roundResult.getCarList();

        assertAll(
            assertThat(secondCarList.size() != firstCarList.size())::isTrue,
            () -> assertThat(firstCarList).hasSize(2),
            () -> assertThat(secondCarList).hasSize(1)
        );
    }

}

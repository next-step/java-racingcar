package racing;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarCollection;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class CarCollectionTest {

    @DisplayName("string type의 이름을 받고 공백을 제거하여 LIST<Car>를 생성한다.")
    @Test
    void inputStringReturnCarList() {

        CarCollection actualCollection = new CarCollection(CarCollection.initCars("lucas  ,kai"));

        assertThat(actualCollection.getCars())
                .hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("lucas", "kai");
    }

    @DisplayName("중복된 차이름 방지")
    @Test
    void duplicatePrevention(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                            CarCollection actualCollection = new CarCollection(CarCollection.initCars("lucas  ,lucas"));
                        }
                ).withMessageContaining("중복된 차이름");

    }

}

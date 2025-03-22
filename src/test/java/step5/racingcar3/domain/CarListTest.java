package step5.racingcar3.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarListTest {

    @Test
    @DisplayName("CarList 일급컬렉션 생성 테스트")
    void givenCarList_whenCreateCarList_thenSuccess() {
        // given
        Car car1 = new Car(new CarName("a"), new CarEngine(), new Position());
        Car car2 = new Car(new CarName("b"), new CarEngine(), new Position());
        Car car3 = new Car(new CarName("c"), new CarEngine(), new Position());
        Car car4 = new Car(new CarName("d"), new CarEngine(), new Position());
        Car car5 = new Car(new CarName("e"), new CarEngine(), new Position());

        // when
        // then
        assertDoesNotThrow(() -> new CarList(List.of(car1, car2, car3, car4, car5)));
    }

}

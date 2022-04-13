package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final CarName POBI = new CarName("POBI");
    private static final CarName CRONG = new CarName("CRONG");

    @DisplayName("Car는 위치와 이름이 같으면 동등")
    @Test
    void equals() {
        Car pobiCar1 = new Car(POBI);
        Car pobiCar2 = new Car(POBI);

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            pobiCar1.move(() -> true);
            pobiCar2.move(() -> true);
        }

        assertThat(pobiCar1).isEqualTo(pobiCar2);
    }

    @DisplayName("Car는 이름이 다르면 동등X")
    @Test
    void equals_Fail_When_Different_CarName() {
        Car pobiCar = new Car(POBI);
        Car crongCar = new Car(CRONG);

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            pobiCar.move(() -> true);
            crongCar.move(() -> true);
        }

        assertThat(pobiCar).isNotEqualTo(crongCar);
    }

    @DisplayName("Car는 위치가 다르면 동등X")
    @Test
    void equals_Fail_When_Move_Call_Count_Not_Match() {
        Car pobiCar1 = new Car(POBI);
        Car pobiCar2 = new Car(POBI);

        pobiCar1.move(() -> true);

        assertThat(pobiCar1).isNotEqualTo(pobiCar2);
    }

}

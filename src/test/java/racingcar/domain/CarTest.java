package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final CarName POBI = new CarName("POBI");
    private static final CarName CRONG = new CarName("CRONG");

    @Test
    void equals_ReturnsTrue_IfCarNamesAndPositionAreSame() {
        Car pobiCar1 = new Car(POBI, new Position());
        Car pobiCar2 = new Car(POBI, new Position());

        assertThat(pobiCar1).isEqualTo(pobiCar2);
    }

    @Test
    void equals_ReturnsFalse_IfCarNamesAreDifferent() {
        Car pobiCar = new Car(POBI, new Position());
        Car crongCar = new Car(CRONG, new Position());

        assertThat(pobiCar).isNotEqualTo(crongCar);
    }

    @Test
    void equals_ReturnsFalse_IfPositionsAreDifferent() {
        Car pobiCar1 = new Car(POBI, new Position(2));
        Car pobiCar2 = new Car(POBI, new Position(3));

        assertThat(pobiCar1).isNotEqualTo(pobiCar2);
    }

    @Test
    void move_IncreasesPosition_IfConditionIsTrue() {
        int startPosition = 5;
        Car pobiCar = new Car(POBI, new Position(startPosition));

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            pobiCar.move(() -> true);
        }

        assertThat(pobiCar.getPosition()).isEqualTo(startPosition + moveCount);
    }

    @Test
    void move_DoesNotIncreasePosition_IfConditionIsFalse() {
        int startPosition = 5;
        Car pobiCar = new Car(POBI, new Position(startPosition));

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            pobiCar.move(() -> false);
        }

        assertThat(pobiCar.getPosition()).isEqualTo(startPosition);
    }

    @Test
    void compareTo() {
        Car thousandCar = new Car(POBI, new Position(1000));
        Car hundredCar = new Car(POBI, new Position(100));

        assertThat(thousandCar).isGreaterThan(hundredCar);
    }

    @Test
    void compareTo_Returns0_IfPositionsAreSame() {
        Car tenCar1 = new Car(POBI, new Position(10));
        Car tenCar2 = new Car(POBI, new Position(10));

        assertThat(tenCar1).isEqualByComparingTo(tenCar2);
    }
}

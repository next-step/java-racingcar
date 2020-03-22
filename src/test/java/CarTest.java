import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car myCar;

    @BeforeEach
    public void setup() {
        myCar = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void givenSmallerThanFourCarDoesNotMove(int condition) {
        // Given
        int currentPosition = myCar.getCurrentPosition();
        // When
        myCar.move(condition);
        // Then
        assertThat(myCar.getCurrentPosition()).isEqualTo(currentPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void givenGreaterThanFourCarMoves(int condition) {
        // Given
        int currentPosition = myCar.getCurrentPosition();
        // When
        myCar.move(condition);
        // Then
        assertThat(myCar.getCurrentPosition()).isEqualTo(currentPosition);
    }


}

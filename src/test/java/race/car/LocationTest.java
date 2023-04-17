package race.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocationTest {
    Location location;

    @BeforeEach
    void setUp() {
        this.location = new Location();
    }


    @Test
    @DisplayName("moveOnePoint 메서드 호출시 1칸 전진한다.")
    void move() {
        location.moveOnePoint();

        assertThat(location)
                .extracting("location")
                .isEqualTo(1);
    }
}

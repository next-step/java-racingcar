package race.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocationTest {
    @Test
    @DisplayName("Location 객체 생성 및 확인")
    void create() {
        final Location location = new Location(4);

        assertThat(location)
                .isEqualTo(new Location(4));
    }


    @Test
    @DisplayName("moveOnePoint 메서드 호출시 1칸 전진한다.")
    void move() {
        final Location location = new Location(4);
        location.moveOnePoint();

        assertThat(location)
                .isEqualTo(new Location(5));
    }
}

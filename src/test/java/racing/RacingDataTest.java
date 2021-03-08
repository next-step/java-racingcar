package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDataTest {
    List<Driver> drivers;
    int carsCount;
    int attemptsCount;

    @BeforeEach
    void setUp() {
        drivers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            drivers.add(new Driver(new Car()));
        }
        carsCount = 6;
        attemptsCount = 8;
    }

    @Test
    @DisplayName("생성자에 넣어준 값과 getter들의 리턴값은 같아야 한다.")
    void should_ReturnEachValue_When_callToGetters() {
        final RacingData data = new RacingData(drivers, carsCount, attemptsCount);

        assertThat(data.getDrivers()).isEqualTo(drivers);
        assertThat(data.getCarsCount()).isEqualTo(carsCount);
        assertThat(data.getAttemptsCount()).isEqualTo(attemptsCount);
    }

    @Test
    @DisplayName("원래 데이터와 copyWith()로 생성한 새로운 데이터를 같지 않아야 한다.")
    void should_NotEqualOriginData_ForCopyWithData() {
        final RacingData originData = new RacingData(carsCount, attemptsCount);
        final RacingData newData = originData.copyWith(drivers);

        assertThat(newData).isNotEqualTo(originData);
    }

    @Test
    @DisplayName("copyWith()로 생성한 데이터는 drivers는 새로운 값을, 다른 값은 기존 값을 가진다.")
    // TODO: 네이밍 변경
    void copyWithTest() {
        final RacingData originData = new RacingData(carsCount, attemptsCount);
        final RacingData newData = originData.copyWith(drivers);

        assertThat(newData.getDrivers()).isEqualTo(drivers);
        assertThat(newData.getCarsCount()).isEqualTo(originData.getCarsCount());
        assertThat(newData.getAttemptsCount()).isEqualTo(originData.getAttemptsCount());
    }
}

package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CurrentLocation;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentLocationTest {
    @Test
    @DisplayName("현재 위치를 반환")
    public void getCurrentLocationTest() {
        CurrentLocation currentLocation = new CurrentLocation(2);

        assertThat(currentLocation.getCurrentLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("위치를 지정하지 않을 경우 기본 값(0)으로 초기화")
    public void getDefaultCurrentLocationTest() {
        CurrentLocation currentLocation = new CurrentLocation();
        assertThat(currentLocation.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("위치를 비교하여 같은 경우 True / 다를 경우 False를 반환")
    public void isSameLocationTest() {
        CurrentLocation currentLocation = new CurrentLocation(3);

        assertThat(currentLocation.isSameLocation(2)).isFalse();
        assertThat(currentLocation.isSameLocation(3)).isTrue();
    }
}

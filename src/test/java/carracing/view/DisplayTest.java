package carracing.view;

import carracing.domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTest {

    @Test
    void getCurrentStatus() {
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        assertThat(Display.getCurrentStatus(cars)).isEqualTo("a: \nb: \n");
    }

    @Test
    void getWinnerAnnouncement() {
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        assertThat(Display.getWinnerAnnouncement(cars)).isEqualTo("a,b가 최종 우승했습니다.");
    }
}
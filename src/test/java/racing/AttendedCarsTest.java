package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.AttendedCars;
import racing.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AttendedCarsTest {
    @Test
    @DisplayName("이름 String 값 입력을 통한 생성자 테스트")
    public void nameOfCarInputConstructorTest() {
        AttendedCars attendedCars = new AttendedCars("자바,파이썬,JS,고,러스트");

        assertThat(attendedCars.getAttendance()).isEqualTo(5);
    }

    @Test
    @DisplayName("게임에 참가한 자동차에서 가장 먼 거리를 간 자동차들을 반환")
    public void getWinners() {
        Car pobi = new Car("pobi", 4);
        Car jason = new Car("jason", 2);
        Car woni = new Car("woni", 4);
        List<Car> cars = Arrays.asList(pobi, jason, woni);

        AttendedCars attendedCars = new AttendedCars(cars);

        List<Car> winners = attendedCars.getWinners();

        assertThat(winners).contains(pobi, woni);
    }

    @Test
    @DisplayName("참여 중인 모든 자동차들을 이동")
    public void testAttendedCars() {
        AttendedCars attendedCars = new AttendedCars("참여1,참여2,참여2");

        attendedCars.moveAttendedCars(new int[] {1, 3, 2});

        for (int i = 0; i < attendedCars.getAttendance(); i++) {
            assertThat(attendedCars.getAttendedCars().get(i).getCurrentLocation()).isEqualTo(0);
        }

        attendedCars.moveAttendedCars(new int[] {5, 6, 4});

        for (int i = 0; i < attendedCars.getAttendance(); i++) {
            assertThat(attendedCars.getAttendedCars().get(i).getCurrentLocation()).isEqualTo(1);
        }
    }
}

package racingGame.participant;

import org.junit.jupiter.api.Test;
import racingGame.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    void winner() {
        List<Car> carList = new ArrayList<>();
        Car yohan = new Car("yohan");
        Car hyemin = new Car("hyemin");
        Car hyeji = new Car("hyeji");

        yohan.forward();
        yohan.forward();
        yohan.forward();
        hyemin.forward();
        hyemin.forward();
        hyemin.forward();
        hyeji.forward();

        carList.add(yohan);
        carList.add(hyemin);
        carList.add(hyeji);

        FakeParticipants fakeParticipants = new FakeParticipants(carList);
        assertThat(fakeParticipants.getWinners()).containsExactly(yohan, hyemin);
    }

}
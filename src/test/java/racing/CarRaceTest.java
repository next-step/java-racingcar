package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    @Test
    void getWinners() {
        Car car1 = new Car("Tom", 8);
        Car car2 = new Car("Popo", 14);
        Car car3 = new Car("Papa", 14);

        CarRace carRace = new CarRace();

        carRace.confirmWinners(car1);
        carRace.confirmWinners(car2);
        carRace.confirmWinners(car3);

        Assertions.assertThat(carRace.winnersPrint()).isEqualTo("최종 우승자 : [Popo, Papa]");
    }

}
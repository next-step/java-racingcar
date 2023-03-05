package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    Car car;
    ArrayList<Car> carArrayList = new ArrayList<Car>();
    CarRace carRace = new CarRace();

    @Test
    @DisplayName("최대값 계산이 제대로 되고있는지 확인")
    void runningRace() {
        carArrayList.add(new Car("tommy"));
        carArrayList.add(new Car("bear"));
        carArrayList.add(new Car("schum"));

        int maxDistance = 0;

        carRace.runningRace(carArrayList);

        for(int i = 0; i < carArrayList.size(); i++) {
            if(maxDistance < carArrayList.get(i).getDistance()) {
                maxDistance = carArrayList.get(i).getDistance();
            }
        }

        System.out.println(maxDistance);
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(maxDistance);
    }

    @Test
    void getWinners() {
        carRace.winners = new ArrayList<>();
        carRace.winners.add("Tommy");
        CarRace.maxDistance = 10;


        Car car1 = new Car("Tom", 8);

        carRace.confirmWinners(car1);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Tommy");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(10);


        Car car2 = new Car("Popo", 14);

        carRace.confirmWinners(car2);

        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Popo");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(14);


        Car car3 = new Car("Papa", 14);

        carRace.confirmWinners(car3);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Popo");
        Assertions.assertThat(carRace.winners.get(1)).isEqualTo("Papa");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(14);


        car = new Car("Tommy", 20);

        carRace.confirmWinners(car);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Tommy");
        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                        .isThrownBy(() -> carRace.winners.get(1));
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(20);
    }

    @Test
    void winnersPrint() {
        carRace.winners.add("Tommy");
        carRace.winners.add("Bear");
        Assertions.assertThat(carRace.winnersPrint()).isEqualTo("최종 우승자 : [Tommy, Bear]");
    }
}
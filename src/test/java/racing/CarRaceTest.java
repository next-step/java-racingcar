package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    Car car = new Car();
    Car[] carArr = new Car[3];
    CarRace carRace = new CarRace();

    @Test
    @DisplayName("최대값 계산이 제대로 되고있는지 확인")
    void runningRace() {
        carArr[0] = new Car();
        carArr[0].setCarName("tommy");
        carArr[1] = new Car();
        carArr[1].setCarName("bear");
        carArr[2] = new Car();
        carArr[2].setCarName("schum");
        int maxDistance = 0;

        carRace.runningRace(carArr);

        for(int i=0; i < carArr.length; i++) {
            if(maxDistance < carArr[i].getDistance()) {
                maxDistance = carArr[i].getDistance();
            }
        }

        System.out.println(maxDistance);
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(maxDistance);
    }

    @Test
    void getMaxDistance() {
        carRace.winners.add("Tommy");
        CarRace.maxDistance = 10;

        car.setCarName("Bear");
        car.setDistance(8);

        carRace.getMaxDistance(car);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Tommy");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(10);


        car.setCarName("Popo");
        car.setDistance(14);

        carRace.getMaxDistance(car);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Popo");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(14);


        car.setCarName("Papa");
        car.setDistance(14);

        carRace.getMaxDistance(car);
        Assertions.assertThat(carRace.winners.get(0)).isEqualTo("Popo");
        Assertions.assertThat(carRace.winners.get(1)).isEqualTo("Papa");
        Assertions.assertThat(CarRace.maxDistance).isEqualTo(14);


        car.setCarName("Tommy");
        car.setDistance(20);

        carRace.getMaxDistance(car);
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
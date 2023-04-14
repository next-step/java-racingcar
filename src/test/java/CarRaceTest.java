import entity.car.Car;
import entity.race.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @ParameterizedTest
    @DisplayName("레이싱 경주 초기화")
    @CsvSource(value = {"2:2:hyu,sam", "3:5:apple,hyun,samg"}, delimiter = ':')
    public void initRacing(int numberOfCar, int round, String carName) {
        CarRace carRace = CarRace.initRace(numberOfCar, round, carName);

        assertThat(numberOfCar).isEqualTo(carRace.getRacingCars().getCars().size());
        assertThat(round).isEqualTo(carRace.getRoundValue());
    }

    @Test
    @DisplayName("전진_조건_랜덤_값_구하기_0 이상 9 이하")
    public void 전진_조건_랜덤_값_구하기(){
        //given
        Car car = new Car("ㅅㄷㄴㅅ");
        int result = car.moveOrNot();
        //when
        assertThat(result).isGreaterThanOrEqualTo(0).isLessThan(10);
    }

    @Test
    @DisplayName("레이싱_레이스_로직_구현")
    public void 레이싱_레이스_로직_구현(){
        //given
        CarRace carRace = CarRace.initRace(3, 5, "apple,hyui,sams");
        carRace.race();
        //when
        List<Integer> moveList = carRace.getRacingCars().getCars().stream()
                .map(Car::getPositionValue)
                .collect(Collectors.toList());

        assertThat(moveList).containsAnyOf(0,1,2,3,4,5);
    }


}

package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.CarDistance;
import racinggame.domain.CarName;
import racinggame.domain.RacingCars;
import racinggame.dto.RaceInputDTO;
import racinggame.dto.RaceResultDTO;
import racinggame.dto.WinCarsDTO;
import racinggame.service.RaceService;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    @Test
    void 자동차_경주_횟수만큼_자동차가_이동한다() {
        //given
        RaceInputDTO raceInputDTO = new RaceInputDTO(3, new String[] {"car1", "car2", "car3"});

        IntPredicate canMovePredicate = randomNumber -> true;
        List<Car> cars = List.of(
                new Car("car1", canMovePredicate),
                new Car("car2", canMovePredicate),
                new Car("car3", canMovePredicate));

        RaceService raceService = new RaceService();

        //when
        raceService.startRace(raceInputDTO, new RacingCars(cars));

        //then
        assertThat(cars.get(0).getCarDistance()).isEqualTo(new CarDistance(3));
        assertThat(cars.get(0).getCarName()).isEqualTo(new CarName("car1"));
    }

    @Test
    void 우승자_찾기() {
        //given
        RaceInputDTO raceInputDTO = new RaceInputDTO(3, new String[] {"car1", "car2", "car3"});

        List<Car> cars = List.of(
                new Car("car1", randomNumber -> true),
                new Car("car2", randomNumber -> false),
                new Car("car3", randomNumber -> true));

        RaceService raceService = new RaceService();

        //when
        RaceResultDTO raceResultDTO = raceService.startRace(raceInputDTO, new RacingCars(cars));

        //then
        List<WinCarsDTO> winners = raceResultDTO.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getCarName()).isEqualTo(new CarName("car1"));
        assertThat(winners.get(1).getCarName()).isEqualTo(new CarName("car3"));
    }
}
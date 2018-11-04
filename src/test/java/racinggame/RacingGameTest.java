package racinggame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class RacingGameTest {

    String [] carName;

    @Before
    public void 레이싱_카셋팅(){
        carName = "pobi,crong,honux".split(",");
    }

    @Test
    public void 레이싱_게임생성(){
        RacingGame racingGame = new RacingGame(carName, 5);
        assertEquals(racingGame.getCars().size(), 3);
        assertThat(racingGame.nextRacingGame()).isTrue();
    }

    @Test
    public void 레이싱_게임_끝난경우(){
        RacingGame racingGame = new RacingGame(carName, 1);
        racingGame.move();
        assertThat(racingGame.nextRacingGame()).isFalse();
    }

    @Test
    public void 레이싱_게임_진행가능한경우(){
        RacingGame racingGame = new RacingGame(carName, 2);
        racingGame.move();
        assertThat(racingGame.nextRacingGame()).isTrue();
    }

    @Test
    public void 레이싱_순위_1등(){
        RacingGame racingGame = new RacingGame(carName, 2){
            @Override
            public List<Car> getCars() {
                List<Car> cars = new ArrayList<>();
                cars.add(new Car("pobi", 0));
                cars.add(new Car("crong", 5));
                cars.add(new Car("honux", 3));
                return cars;
            }

            @Override
            public int getMaxLocation() {
                return getCars().stream().collect(Collectors.summarizingInt(Car::getLocation)).getMax();
            }

            @Override
            public List<String> getVictorCar() {
                int maxLocation = getMaxLocation();
                return getCars().stream()
                        .filter(car -> car.equalsPosition(maxLocation))
                        .map(Car::getName)
                        .collect(Collectors.toList());
            }
        };

        assertThat(racingGame.getMaxLocation()).isEqualTo(5);
        assertEquals(racingGame.getVictorCar().size(), 1);
    }

    @Test
    public void 레이싱_순위_공동1등(){
        RacingGame racingGame = new RacingGame(carName, 2){
            @Override
            public List<Car> getCars() {
                List<Car> cars = new ArrayList<>();
                cars.add(new Car("pobi", 5));
                cars.add(new Car("crong", 5));
                cars.add(new Car("honux", 3));
                return cars;
            }

            @Override
            public int getMaxLocation() {
                return getCars().stream().collect(Collectors.summarizingInt(Car::getLocation)).getMax();
            }

            @Override
            public List<String> getVictorCar() {
                int maxLocation = getMaxLocation();
                return getCars().stream()
                        .filter(car -> car.equalsPosition(maxLocation))
                        .map(Car::getName)
                        .collect(Collectors.toList());
            }
        };

        assertThat(racingGame.getMaxLocation()).isEqualTo(5);
        assertEquals(racingGame.getVictorCar().size(), 2);
    }

}
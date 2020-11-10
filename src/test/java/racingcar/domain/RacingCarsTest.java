package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;
    private List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        RacingCar racingCar1 = new RacingCar("현대");
        RacingCar racingCar2 = new RacingCar("기아");
        RacingCar racingCar3 = new RacingCar("쉐보레");
        RacingCar racingCar4 = new RacingCar("폭스바겐");
        RacingCar racingCar5 = new RacingCar("BMW");

        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);
        racingCarList.add(racingCar4);
        racingCarList.add(racingCar5);

        racingCars = new RacingCars(racingCarList);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 4, 2, 5})
    public void roundExecuteTest(int executeCount) {
        //Given & When
        Commander commander = () -> true;
        IntStream.range(0, executeCount)
                .forEach((i) -> racingCars.roundExecute(i, commander));

        //Then
        assertThat(racingCars.getWinner()).hasSize(executeCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 4, 2, 5})
    public void getResultTest(int executeCount) {
        //Given
        Commander commander = () -> true;

        //When
        IntStream.range(0, executeCount)
                .forEach((i) -> racingCars.roundExecute(i, commander));
        List<Integer> result = racingCars.getResult();

        //Then
        assertThat(result).hasSize(racingCarList.size());

    }


    @Test
    public void getCarNameTest() {
        //Given & When
        List<String> racingCarNames = racingCars.getCarName();

        //Then
        assertThat(racingCarNames).contains("현대", "기아", "쉐보레", "폭스바겐", "BMW");
    }

}

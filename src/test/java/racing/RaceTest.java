package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.Race;
import racing.view.ResultView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racing.domain.CarFactory.mustGoMoveConditionSupplier;
import static racing.view.ResultView.RACE_FINISHED;
import static racing.view.ResultView.RACE_START;

public class RaceTest {

    private List<String> carNames;
    private int numberOfLaps;

    @BeforeEach
    public void setUp() {
        carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        numberOfLaps = 5;
    }

    @Test
    public void 사용자가_입력한만큼의_자동차를_생성해야한다() {
        List<Car> cars = CarFactory.createRacingCars(carNames);
        Race race = new Race(cars, numberOfLaps);
        assertThat(race.getCars().size()).isEqualTo(carNames.size());
    }

    @Test
    public void 사용자가_입력한만큼의_횟수를_반복해야한다() {
        List<Car> cars = CarFactory.createRacingCars(carNames);
        Race race = new Race(cars, numberOfLaps);
        assertThat(race.getNumberOfLaps()).isEqualTo(numberOfLaps);
    }

    @Disabled // TODO: ResultView로 결과화면 테스트 책임을 이전해야 합니다.
    @Test
    public void 사용자가_입력한만큼_횟수를_반복한결과를_화면에보여줘야한다() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            List<Car> cars = CarFactory.createRacingCars(carNames, mustGoMoveConditionSupplier);
            Race race = new Race(cars, numberOfLaps);
            race.startRacingAndReturnWinner();

            int numberOfCars = carNames.size();
            String firstLap = String.format("%s\n", ResultView.CAR_POSITION_PROGRESS).repeat(numberOfCars);
            String lastLap = String.format("%s\n", ResultView.CAR_POSITION_PROGRESS.repeat(numberOfLaps)).repeat(numberOfCars);

            assertThat(outContent.toString())
                    .contains(firstLap)
                    .contains(lastLap)
                    .contains(RACE_START)
                    .contains(RACE_FINISHED);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void givenCarList_whenFinishedLap_thenGetCarRacingWinner() {
        List<Car> cars = CarFactory.createRacingCars(carNames, mustGoMoveConditionSupplier);

        Race race = new Race(cars, numberOfLaps);
        List<Car> winners = race.startRacingAndReturnWinner();

        assertThat(winners).hasSize(3);
    }
}

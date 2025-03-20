package racing;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racing.CarFactory.mustGoMoveConditionSupplier;
import static racing.ResultView.RACE_FINISHED;
import static racing.ResultView.RACE_START;

public class RaceTest {
    @Test
    public void 사용자가_입력한만큼의_자동차를_생성해야한다() {
        String[] carNames = {"car1", "car2", "car3"};
        int numberOfLaps = 5;

        List<Car> cars = CarFactory.createRacingCars(carNames);
        Race race = new Race(cars, numberOfLaps);
        assertThat(race.getCars().size()).isEqualTo(carNames.length);
    }

    @Test
    public void 사용자가_입력한만큼의_횟수를_반복해야한다() {
        String[] carNames = {"car1", "car2", "car3"};
        int numberOfLaps = 5;
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
            String[] carNames = {"car1", "car2", "car3"};
            int numberOfLaps = 5;
            List<Car> cars = CarFactory.createRacingCars(carNames, mustGoMoveConditionSupplier);
            Race race = new Race(cars, numberOfLaps);
            race.startRacingAndReturnWinner();

            int numberOfCars = carNames.length;
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
        String[] carNames = {"car1", "car2", "car3"};
        int numberOfLaps = 5;
        List<Car> cars = CarFactory.createRacingCars(carNames, mustGoMoveConditionSupplier);

        Race race = new Race(cars, numberOfLaps);
        List<Car> winners = race.startRacingAndReturnWinner();

        assertThat(winners).hasSize(3);
    }
}

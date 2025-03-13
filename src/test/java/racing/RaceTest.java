package racing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racing.ResultView.RACE_FINISHED;
import static racing.ResultView.RACE_START;

public class RaceTest {
    @Test
    public void 사용자가_입력한만큼의_자동차를_생성해야한다() {
        int numberOfCars = 3;
        int numberOfTries = 5;

        Race race = new Race(numberOfCars, numberOfTries);
        assertThat(race.getCars().size()).isEqualTo(numberOfCars);
    }

    @Test
    public void 사용자가_입력한만큼의_횟수를_반복해야한다() {
        int numberOfCars = 3;
        int numberOfTries = 5;
        Race race = new Race(numberOfCars, numberOfTries);
        assertThat(race.getNumberOfLaps()).isEqualTo(numberOfTries);
    }

    @Test
    public void 사용자가_입력한만큼_횟수를_반복한결과를_화면에보여줘야한다() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            int numberOfCars = 3;
            int numberOfTries = 5;
            int carMovePowerCondition = 0;
            Race race = new Race(numberOfCars, numberOfTries, carMovePowerCondition);

            race.startRacing();

            String firstLap = String.format("%s\n", ResultView.CAR_POSITION_PROGRESS).repeat(numberOfCars);
            String lastLap = String.format("%s\n", ResultView.CAR_POSITION_PROGRESS.repeat(numberOfTries)).repeat(numberOfCars);

            assertThat(outContent.toString())
                    .contains(firstLap)
                    .contains(lastLap)
                    .contains(RACE_START)
                    .contains(RACE_FINISHED);
        } finally {
            System.setOut(originalOut);
        }
    }
}

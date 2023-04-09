package study.carrace.step3.presentation;

import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.Car;
import study.carrace.step3.domain.RandomIntegerGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceMonitorTest {
    @Test
    void 전진_자동차_위치_출력() {
        // given
        int movableThreshold = 0;
        int generatedRandomInteger = 1;

        Car alwaysMoveCar = createMockCar(movableThreshold, generatedRandomInteger);
        RaceMonitor raceMonitor = new RaceMonitor(List.of(alwaysMoveCar));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        systemSetOut(outputStream);

        // when
        alwaysMoveCar.moveOrStop();
        raceMonitor.showCarsPosition();

        // then
        assertThat(outputStream.toString()).isEqualTo("🚙-\n");
    }

    @Test
    void 멈춤_자동차_위치_출력() {
        // given
        int movableThreshold = 1;
        int generatedRandomInteger = 0;

        Car alwaysStopCar = createMockCar(movableThreshold, generatedRandomInteger);
        RaceMonitor raceMonitor = new RaceMonitor(List.of(alwaysStopCar));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        systemSetOut(outputStream);

        // when
        alwaysStopCar.moveOrStop();
        raceMonitor.showCarsPosition();

        // then
        assertThat(outputStream.toString()).isEqualTo("🚙\n");
    }

    private Car createMockCar(int movableThreshold, int generatedRandomInteger) {
        return new Car(createMockRandomIntegerGenerator(generatedRandomInteger), movableThreshold);
    }

    private RandomIntegerGenerator createMockRandomIntegerGenerator(int generated) {
        return () -> generated;
    }

    private void systemSetOut(ByteArrayOutputStream outputStream) {
        System.setOut(new PrintStream(outputStream));
    }
}
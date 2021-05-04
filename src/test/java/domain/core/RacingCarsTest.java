package domain.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("입력한 횟수만큼 실제로 경주하는지")
    void two_car_play() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("santa")));
        cars.add(new Car(new CarName("volt")));
        RacingCars racingCars = new RacingCars(cars);

        //when
        racingCars.moveAll(1);

        //then
        assertThat(outContent.toString()).isIn(
                "santa: \n" +
                        "volt: \n\n",
                "santa: -\n" +
                        "volt: \n\n",
                "santa: \n" +
                        "volt: -\n\n",
                "santa: -\n" +
                        "volt: -\n\n"
        );
    }

    @Test
    @DisplayName("승리한 volt 이름 출력")
    void print_winner() {
        //given
        Car santa = new Car(new CarName("santa"));
        Car tesla = new Car(new CarName("tesla"));
        Car volt = new Car(new CarName("volt"));
        Accelerator go = new Accelerator(5);
        Accelerator stop = new Accelerator(3);
        for (int i = 0; i < 10; i++) {
            volt.move(go);
            santa.move(stop);
            tesla.move(stop);
        }
        RacingCars racingCars = new RacingCars(Arrays.asList(santa, tesla, volt));

        //when
        racingCars.printWinner();

        //then
        assertThat(outContent.toString()).isEqualTo("volt 승리하였습니다.\n");
    }

    @Test
    @DisplayName("공동 승리한 santa, volt 이름 출력")
    void print_co_winner() {
        //given
        Car santa = new Car(new CarName("santa"));
        Car tesla = new Car(new CarName("tesla"));
        Car volt = new Car(new CarName("volt"));
        Accelerator go = new Accelerator(5);
        Accelerator stop = new Accelerator(3);
        for (int i = 0; i < 10; i++) {
            santa.move(go);
            volt.move(go);
            tesla.move(stop);
        }
        RacingCars racingCars = new RacingCars(Arrays.asList(santa, tesla, volt));

        //when
        racingCars.printWinner();

        //then
        assertThat(outContent.toString()).isEqualTo("santa, volt 승리하였습니다.\n");
    }

}

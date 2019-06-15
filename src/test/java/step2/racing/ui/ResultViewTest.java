package step2.racing.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.racing.model.Car;
import step2.racing.random.RandomGenerator;
import step2.racing.random.StubRandomGenerator;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private RandomGenerator moveStubRandomGenerator = new StubRandomGenerator(7);
    private RandomGenerator notMoveStubRandomGenerator = new StubRandomGenerator(2);

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void printEntireCarsPosition() {

        List<Car> cars = Arrays.asList(
                Car.of(0, moveStubRandomGenerator),
                Car.of(1, notMoveStubRandomGenerator),
                Car.of(2, moveStubRandomGenerator)
        );

        cars.forEach(Car::race);
        resultView.printEntireCarsPosition(cars);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("\n"
                         + "--\n"
                         + "-\n"
                         + "--\n");

    }
}
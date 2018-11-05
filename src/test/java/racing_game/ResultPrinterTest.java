package racing_game;

import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultPrinterTest {

    @Test
    public void 현재상태_출력_확인() {
        MockPrintStream mockPrintStream = new MockPrintStream(System.out);
        ResultPrinter resultPrinter = new ResultPrinter(mockPrintStream);
        final String carName = "pobi";

        resultPrinter.printCurrentState(carName, 3);

        String inputString = mockPrintStream.getInputString();
        assertThat(inputString).isEqualTo(carName + " : " + "---");
    }

    @Test
    public void 게임결과_출력_확인() {
        MockPrintStream mockPrintStream = new MockPrintStream(System.out);
        ResultPrinter resultPrinter = new ResultPrinter(mockPrintStream);

        final int carCount = 3;
        List<Car> cars = createCars(carCount);

        resultPrinter.printGameResult(cars);

        String inputString = mockPrintStream.getInputString();
        assertThat(inputString).isEqualTo(carCount + "가 최종 우승했습니다.");
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new TestCar(String.valueOf(i + 1), i + 1));
        }

        return cars;
    }

    private static class MockPrintStream extends PrintStream {

        private String inputString;

        public MockPrintStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            this.inputString = x;
        }

        public String getInputString() {
            return inputString;
        }
    }

    private static class TestCar extends Car {

        private final int moveCount;

        public TestCar(String name, int moveCount) {
            super(name);
            this.moveCount = moveCount;
        }

        @Override
        public int getMoveCount() {
            return this.moveCount;
        }
    }

}
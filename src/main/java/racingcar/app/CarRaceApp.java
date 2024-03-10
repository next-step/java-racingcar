package racingcar.app;

import racingcar.Cars;
import racingcar.ui.ConsoleInputReader;
import racingcar.ui.ConsoleOutputMessageType;
import racingcar.ui.ConsoleOutputWriter;

public class CarRaceApp {

    public static void main(String[] args) {
        ConsoleOutputWriter.write(ConsoleOutputMessageType.HOW_MANY_CARS);
        int carCount = ConsoleInputReader.readInt();

        ConsoleOutputWriter.write(ConsoleOutputMessageType.HOW_MANY_TRYS);
        int tryCount = ConsoleInputReader.readInt();

        Cars cars = new Cars(carCount);
        ConsoleOutputWriter.write(ConsoleOutputMessageType.EXECUTE_RESULT);
        while (tryCount-- > 0) {
            cars.move();
            ConsoleOutputWriter.write(cars.toString());
        }
    }

}

package racingcar.app;

import racingcar.Cars;
import racingcar.ui.ConsoleInputReader;
import racingcar.ui.ConsoleOutputMessage;
import racingcar.ui.ConsoleOutputWriter;

public class CarRaceApp {

    public static void main(String[] args) {
        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_CARS);
        int carCount = ConsoleInputReader.readInt();

        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_TRYS);
        int tryCount = ConsoleInputReader.readInt();

        Cars cars = new Cars(carCount);
        cars.move(tryCount);

        ConsoleOutputWriter.write(cars.toString());
    }

}

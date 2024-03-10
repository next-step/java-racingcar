package racingcar.app;

import racingcar.Car;
import racingcar.Cars;
import racingcar.RandomValueGenerator;
import racingcar.ui.ConsoleInputReader;
import racingcar.ui.ConsoleOutputMessage;
import racingcar.ui.ConsoleOutputWriter;

public class CarRace {

    public void race() {
        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_CARS);
        int carCount = ConsoleInputReader.readInt();

        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_TRYS);
        int tryCount = ConsoleInputReader.readInt();

        Cars cars = new Cars(carCount);
    }

}

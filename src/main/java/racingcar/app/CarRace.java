package racingcar.app;

import racingcar.Car;
import racingcar.CarMoveCondition;
import racingcar.RandomValueGenerator;
import racingcar.ui.ConsoleInputReader;
import racingcar.ui.ConsoleOutputMessage;
import racingcar.ui.ConsoleOutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    public void race() {
        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_CARS);
        int carCount = ConsoleInputReader.readInt();

        ConsoleOutputWriter.write(ConsoleOutputMessage.HOW_MANY_TRYS);
        int tryCount = ConsoleInputReader.readInt();

        CarMoveCondition moveCondition = new CarMoveCondition();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(moveCondition));
        }

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carList.size(); j++) {
                Car car = carList.get(j);
                car.move(RandomValueGenerator.generate());
            }
        }
    }

}

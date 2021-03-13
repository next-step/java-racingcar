package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {

    private final Logger logger = Logger.getLogger("UI");

    public UserInput getUserInput() {
        Scanner staff = new Scanner(System.in);
        logger.log(Level.INFO, "자동차 대수는 몇 대 인가요?");
        int numberOfCars = staff.nextInt();
        logger.log(Level.INFO, "시도할 회수는 몇 회 인가요?");
        int numberOfRace = staff.nextInt();
        return new UserInput(numberOfCars, numberOfRace);
    }

    public void printScoreboard(List<Car> cars) {
        logger.log(Level.INFO, "=========SCOREBOARD=========");
        cars.forEach(car->logger.log(Level.INFO, car.toString()));
        logger.log(Level.INFO, "");
    }
}

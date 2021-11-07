package race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class GameConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfMovement = scanner.nextInt();

        Collection<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        Race race = new Race(cars, new JudgeCarMovement(new Random()));
        RenderRaceSnapshot renderRaceSnapshot = new RenderRaceSnapshot();

        for (int i = 0; i < numberOfMovement; i++) {
            race.moveCars();
            System.out.println("["+i+"]----------");
            renderRaceSnapshot.render(cars);
        }
    }
}

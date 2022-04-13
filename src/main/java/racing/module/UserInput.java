package racing.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import racing.Car;

public class UserInput {

    private static final String HOW_MANY_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TRIES_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;
    private List<Car> cars = new ArrayList<>();

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public List<Car> settingCarsByUserInput(){
        System.out.println(HOW_MANY_CARS_MESSAGE);
        int carCount = scanner.nextInt();
        for(int i = 0; i <carCount; i++){
            cars.add(new Car());
        }
        return cars;
    }

    public int settingTurnCountByUserInput(){
        System.out.println(HOW_MANY_TRIES_MESSAGE);
        return scanner.nextInt();
    }


}

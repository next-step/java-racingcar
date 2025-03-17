package car_racing.view.service;

import car_racing.view.model.UserInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputService {
    private static final Scanner scanner = new Scanner(System.in);

    public UserInput getUserInput() {
        List<String> namesOfCars = getNamesOfCar();
        int numOfGame = getNumOfGame();
        return new UserInput(namesOfCars, numOfGame);
    }

    private List<String> getNamesOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        List<String> names = Arrays.asList(scanner.nextLine().split(","));
        validateName(names);

        return names;
    }

    private void validateName(List<String> name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("자동차를 하나 이상 입력해야 합니다.");
        }
    }

    private int getNumOfGame() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int numOfGame = scanner.nextInt();
        validateNumOfGame(numOfGame);

        return numOfGame;
    }

    private void validateNumOfGame(int numOfGame) {
        if (numOfGame <= 0) {
            throw new RuntimeException("1회 이상 수행해야 합니다.");
        }
    }
}

package car.view;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Game;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private Game game;

    public Input(Game game) {
        this.game = game;
    }

    public String carNameinput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(\\,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String countInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Cars inputCarNames() {
        String carInput = carNameinput();
        String[] carInputs = carInput.split(",");

        List<Car> createdCars = game.createCars(carInputs);

        if (createdCars.size() < MINIMUM_CAR_AMOUNT) {
            return null;
        }

        return new Cars(createdCars);
    }

    public String inputTryCount() {
        return countInput();
    }
}

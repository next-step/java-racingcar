package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racingcar {
    private final CarEngine carEngine;

    public Racingcar(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    // 테스트용
    public static void main(String[] args) {
        CarEngine carEngine = new RandomEngine();
        Racingcar racingcar = new Racingcar(carEngine);
        racingcar.execute();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String car = scanner.nextLine();
        String round = scanner.nextLine();

        validateInput(car, round);

        Cars cars = new Cars(createCars(Integer.parseInt(car)));

        race(cars, Integer.parseInt(round));
    }

    private List<Car> createCars(int car) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private void race(Cars cars, int round) {
        PrintView printView = new PrintView();
        printView.input(cars.carList.size(), round);

        for (int i = 0; i < round; i++) {
            cars.moveAll(carEngine);
        }
    }

    private void validateInput(String carInput, String roundInput) {
        int car;
        int round;

        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 수 : 올바른 입력값이 아닙니다.");
        }

        if (roundInput == null || roundInput.isEmpty()) {
            throw new IllegalArgumentException("게임 진행 횟수 : 올바른 입력값이 아닙니다.");
        }

        try {
            car = Integer.parseInt(carInput);
            round = Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자(양수)만 입력 가능합니다.");
        }

        if (car < 0 || round < 0) {
            throw new IllegalArgumentException("입력값은 양수만 입력 가능합니다.");
        }
    }
}

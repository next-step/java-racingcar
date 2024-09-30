package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racingcar {
    private final CarEngine carEngine;

    public Racingcar(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    // view 테스트용
    public static void main(String[] args) {
        CarEngine carEngine = new RandomEngine();
        Racingcar racingcar = new Racingcar(carEngine);
        racingcar.execute();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String car = scanner.nextLine();
        String round = scanner.nextLine();

        InputValidator.validate(car, round);

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

        printView.print("실행 결과");
        for (int i = 0; i < round; i++) {
            cars.moveAll(carEngine);
            printView.result(cars);
        }
    }

}

package study.step3.view;

import study.step3.Car;
import study.step3.model.Count;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public Count input() {
        InputView.carCount();
        int carCount = scanner.nextInt();
        InputView.gameCount();
        int gameCount = scanner.nextInt();

        return new Count(carCount, gameCount);
    }

    public void result() {
        ResultView.print();
    }

    public void carStatus(List<Car> cars) {
        for (Car car : cars) {
            ResultView.printPosition(car.getPosition());
        }
        System.out.println("");
    }
}

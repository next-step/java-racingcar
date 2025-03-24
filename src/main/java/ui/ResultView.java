package ui;

import java.util.List;
import java.util.stream.Collectors;

import model.Car;
import model.Racing;

public class ResultView {

    public static void doRaceAndPrintResult(Racing racing) {
        System.out.println("실행 결과");

        while (racing.isRemainTry()) {
            racing.move();
            print(racing);
        }

        printWinner(racing);
    }

    private static void print(Racing racing) {
        List<Car> carList = racing.getCarList();

        for (Car car : carList) {
            print(car);
        }

        System.out.print("\n");
    }

    private static void print(Car car) {
        int position = car.getCurrentPosition();

        System.out.print(car.getCarName() + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }


        System.out.print("\n");
    }

    private static void printWinner(Racing racing) {
        if (racing.isRemainTry()) {
            throw new RuntimeException("아직 시도할 횟수가 남아 있습니다.");
        }

        List<Car> winnerList = racing.getWinner();

        String result = winnerList.stream()
            .map(Car::getCarName)
            .collect(Collectors.joining(","));

        System.out.println(result + "가 최종 우승했습니다.");
    }
}

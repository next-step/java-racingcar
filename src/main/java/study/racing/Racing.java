package study.racing;

import study.racing.domain.Car;
import study.racing.domain.RandomMovingCondition;
import study.racing.factory.CarFactory;
import study.racing.util.RandomNumberGenerator;
import study.racing.util.View;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    public static void main(String[] args) {
        String[] carNames = View.inputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(",");
        final int carCount = carNames.length;
        final int loopCount = View.inputView.inputInt("시도할 회수는 몇 회 인가요?");

        List<Car> cars = CarFactory.createCars(carCount, carNames, new RandomMovingCondition());

        for (int i = 0; i < loopCount; i++) {
            cars.stream().forEach(car -> {
                car.move(RandomNumberGenerator.getInstance().generate());
            });

            printResult(cars);
        }

        printWinner(findWinner(cars));
    }

    private static void printWinner(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        View.outputView.println(winners + "가 최종 우승했습니다.");
    }

    private static void printResult(List<Car> cars) {
        cars.stream().forEach(car -> {
            View.outputView.printRepeatChar(car.getName() + " : ", '-', car.getDistance());
        });

        View.outputView.printRepeatChar();
    }

    private static List<Car> findWinner(List<Car> cars) {
        int winnerDistance = cars.stream()
                .max(Car::compareTo)
                .get()
                .getDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == winnerDistance)
                .collect(Collectors.toList());
    }
}

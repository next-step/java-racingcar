package study.racing.step3;

import java.util.List;

public class Racing {

    public static void main(String[] args) {
        int carCount = View.inputView.input("자동차 대수는 몇 대 인가요?");
        int loopCount = View.inputView.input("시도할 회수는 몇 회 인가요?");

        List<Car> cars = CarFactory.createCars(carCount);

        for (int i = 0; i < loopCount; i++) {
            cars.stream().forEach(car -> {
                car.move(RandomGenerator.generate());
            });

            cars.stream().forEach(car -> {
                View.outputView.printRepeatChar('-', car.getDistance());
            });

            View.outputView.printRepeatChar();
        }
    }
}

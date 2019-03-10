package domain;

import java.util.List;

public class ConsoleOutput implements Output {
    @Override
    public void setCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    @Override
    public void setGameCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    @Override
    public void startMessage() {
        System.out.println("실행 결과");
    }

    @Override
    public void carMileage(List<Car> cars) {
        for (Car car : cars) {
            System.out.print("-");
            for (int i = 0; i < car.getMileage(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

package ui;

import domain.Car;
import domain.CarResult;
import domain.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUI {
    public void setCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    }

    public void setGameCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public void roundResults(List<RoundResult> roundResults) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : roundResults) {
            for (CarResult carResult : roundResult.getCarResults()) {
                System.out.print(carResult.getName() + " : -");
                for (int i = 0; i < carResult.getMileage(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void winners(List<Car> ranking) {
        Integer maxMileage = ranking.get(0).getMileage();

        String result = ranking.stream()
            .filter(c -> c.getMileage().equals(maxMileage))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        result += "가 최종 우승했습니다";

        System.out.println(result);
    }
}

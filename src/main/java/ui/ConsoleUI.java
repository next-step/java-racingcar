package ui;

import domain.Car;
import domain.CarResult;
import domain.RoundResult;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);

    public String setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

    public Integer setGameCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
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

    public void roundResults(List<RoundResult> roundResults) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : roundResults) {
            roundResult(roundResult);
            System.out.println();
        }
    }

    private void roundResult(RoundResult roundResult) {
        for (CarResult carResult : roundResult.getCarResults()) {
            printNameIfHas(carResult);

            IntStream.rangeClosed(0, carResult.getMileage()).forEach(i -> System.out.print("-"));
            System.out.println();
        }
    }

    private void printNameIfHas(CarResult carResult) {
        if(carResult.getName() != null){
            System.out.print(carResult.getName() + " : ");
        }
    }
}

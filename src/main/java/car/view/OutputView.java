package car.view;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.model.Car;
import car.domain.model.Cars;

public final class OutputView {

    private static StringBuilder sb;

    public static void printCarNameText() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printCountText() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultText() {System.out.println("실행 결과");}

    public static void printEachRaceResult(final Cars cars) {
        sb = new StringBuilder();
        cars.getCars()
            .forEach(car -> sb.append(car.getName()).append(" : ")
                .append("-".repeat(car.getPosition())).append("\n"));
        System.out.println(sb.toString());
    }

    public static void printWinner(final List<Car> winner) {
        sb = new StringBuilder();
        sb.append(winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(" ")));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

}

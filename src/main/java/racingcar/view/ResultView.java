package racingcar.view;

import racingcar.service.Car;

import java.util.List;

public class ResultView {
    private static String DISTANCE = "-";

    public static void printNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printNumberOfMovements() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void printRacingResult() {
        System.out.println("실행 결과");
    }

    private static void printDistanceOfCar(int distance) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < distance; i++) {
            sb.append(DISTANCE);
        }

        System.out.println(sb);
    }

    private static void printNameOfCar(String name) {
        System.out.print(name +":");
    }

    public static void printStatusOfCars(List<Car> cars) {
        for(Car car: cars) {
            printNameOfCar(car.getName());
            printDistanceOfCar(car.getDistance());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        printWinner(winners);
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printWinner(List<String> winners) {
        String winnerStr = String.join(",", winners);
        System.out.print(winnerStr);
    }
}

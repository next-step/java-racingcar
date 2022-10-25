package racingcar;

import racingcar.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    public static final Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTrial(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCar(Car car) {
        printName(car.getName());
        System.out.print(" : ");
        printLocation(car.getLocation());
    }

    private void printName(Name name) {
        System.out.print(name.getName());
    }

    private void printLocation(Location location) {
        for (int i = 0; i < location.getLocation(); i++) {
            System.out.print("-");
        }
    }

    public void printWinners(Winners winners) {
        List<String> winnerNames = winners.getWinners().stream()
                .map(Name::getName)
                .collect(Collectors.toList());

        System.out.print((String.join(",", winnerNames)));
        System.out.println("가 최종 우승 했습니다.");
    }
}

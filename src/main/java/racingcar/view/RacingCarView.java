package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RacingCarView {

    private Scanner scan = new Scanner(System.in);
    private int cycle = 0;

    public String inputCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scan.next();
        return input;
    }

    public void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = scan.nextInt();
    }

    public void showResult(List<Car> carInfo) {
        System.out.println("실행결과");
        for (int i = 0; i < cycle; i++) {
            cycleCarInformation(carInfo);
        }
    }

    public void cycleCarInformation(List<Car> carInfo) {
        for (int i = 0; i < carInfo.size(); i++) {
            carInfo.get(i).move();

            System.out.print(carInfo.get(i).getName() + " : ");
            showCarLocationInfo(carInfo.get(i).getLocationInfo());
            System.out.println("");
        }
    }

    public void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public void showWinner(List<Winner> winnerNames) {
        System.out.print("최종 우승자 : ");
        winnerNames.stream().filter(Objects::nonNull).forEach(winner -> System.out.print(winner.getName()));
    }
}

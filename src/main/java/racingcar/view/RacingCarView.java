package racingcar.view;

import racingcar.service.SystemService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarView {
    private SystemService systemService = new SystemService();

    private Scanner scan = new Scanner(System.in);
    private int cycle = 0;

    public RacingCarView() {
        inputCarInfo();
        inputCycle();
        showResult();
        showWinner();
    }

    public void inputCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scan.next();
        systemService.splitString(input);
    }

    public void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = scan.nextInt();
    }

    public void showResult() {
        System.out.println("실행결과");
        for (int i = 0; i < cycle; i++) {
            cycleCarInformation();
        }
    }

    public void cycleCarInformation() {
        for (int i = 0; i < systemService.carInfo.size(); i++) {
            systemService.carInfo.get(i).setLocation(systemService.moveCar());

            System.out.print(systemService.carInfo.get(i).getName() + " : ");
            showCarLocationInfo(systemService.carInfo.get(i).getLocationInfo());
            System.out.println("");
        }
    }

    public void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public void showWinner() {
        List<String> winnerName = systemService.checkWinner(cycle);
        System.out.print("최종 우승자 : ");
        winnerName.stream().filter(Objects::nonNull).forEach(name -> System.out.print(name));
    }
}

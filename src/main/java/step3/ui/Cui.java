package step3.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.RacingHistories;
import step3.domain.RacingHistory;

public class Cui implements Ui{

    @Override
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String carNamesString = scanner.nextLine();
        List<String> carNames = Arrays.stream(carNamesString.split(","))
            .collect(Collectors.toList());
        System.out.println(carNamesString);
        return carNames;
    }

    @Override
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();
        System.out.println(tryCount);
        return tryCount;
    }

    @Override
    public void showResult(RacingHistories histories) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (RacingHistory history : histories.getHistories()) {
            System.out.println(history.getRacerPositionsString());
        }

        System.out.print(histories.printWinner());
        System.out.println(" 이(가) 최종 우승했습니다.");
    }
}

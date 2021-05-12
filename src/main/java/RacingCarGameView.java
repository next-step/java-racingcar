import java.util.Scanner;

public class RacingCarGameView {
    Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자:" + winners);
    }
}

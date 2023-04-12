package racingcar;


import java.util.Scanner;

public class ConsoleView implements InputView, OutputView {

    @Override
    public int getIntegerInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    @Override
    public void printQuestionAboutTheNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    @Override
    public void printQuestionAboutTheNumberOfTrial() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    @Override
    public void printCarLocation(int location) {
        for (int cnt = 0; cnt < location; cnt++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void printResultStatement() {
        System.out.println("실행 결과");
    }
}

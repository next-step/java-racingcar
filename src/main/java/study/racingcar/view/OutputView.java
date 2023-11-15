package study.racingcar.view;

import java.io.PrintStream;

public class OutputView {

    private final PrintStream sout;

    public OutputView(PrintStream out) {
        this.sout = out;
    }

    public void printRequestTextInitCar(){
        sout.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printRequestTextInitRound(){
        sout.println("시도할 회수는 몇 회 인가요?");
    }

}

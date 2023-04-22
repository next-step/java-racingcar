package step3.present;

import java.util.List;

public class OutputPresent {
    public void printResult(List<DisplayRaceVO> collect) {
        System.out.println("실행 결과");
        throw new RuntimeException();
    }

    public void printWinner(List<String> winnerList) {
        throw new RuntimeException();
    }
}

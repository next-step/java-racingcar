package racingcar.view;

import java.util.List;

public class ResultView implements ConsoleView {
    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public void printWinner(List<String> winners) {
        int i = 0;
        for(String winner : winners) {
            System.out.print(winner + ((i == winners.size() - 1) ? "가 최종 우승했습니다." : ","));
            i++;
        }
    }
}

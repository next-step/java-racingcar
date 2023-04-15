package step3.present;

import java.util.List;

public class OutputPresent {
    public void printResult(List<List<String>> collect) {
        System.out.println("실행 결과");
        for (int i = 0; i < collect.get(0).size(); i++) {
            System.out.println();
            for (int j = 0; j < collect.size(); j++) {
                System.out.println(collect.get(j).get(i));
            }
        }
    }

    public void printWinner(List<String> winnerList) {
        System.out.printf("%s 가 최종 우승하였습니다", String.join(",", winnerList));

    }
}

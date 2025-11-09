package racingGame;

import java.util.List;

public class ResultView {
    
    public static void printAllResult(List<List<Integer>> records) {
        System.out.println("실행 결과");
        for (List<Integer> round : records) {   // 한 번의 시도(라운드)
            for (int location : round) {        // 그 라운드의 각 자동차
                for (int i = 0; i < location; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();               // 라운드 사이 공백 줄
        }
    }
}

package step3.racinggame.view;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    public static void printScoreBoard(List<List<Integer>> result) {
        System.out.println("실행 결과");

        for (List<Integer> scores : result) {
            scores.stream()
                    .map("-"::repeat)
                    .forEach(System.out::println);
            System.out.println();
        }
    }

}

package study.step4;

import java.util.ArrayList;
import java.util.List;

public class RankUtil {

    public static List[] ranking(List<Integer> numbers, List<String> names) {
        List[] ranks = new ArrayList[names.size()];
        setUpRankList(ranks);

        for (int i = 0; i < numbers.size(); i++) {
            int rank = 0;
            for (Integer number : numbers) {
                if (numbers.get(i) < number) {
                    rank++;
                }
            }
            ranks[rank].add(names.get(i));
        }
        return ranks;
    }

    private static void setUpRankList(List[] ranks) {
        for (int i = 0; i <ranks.length; i++) {
            ranks[i] = new ArrayList();
        }
    }

}

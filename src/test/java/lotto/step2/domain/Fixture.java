package lotto.step2.domain;

import java.util.List;
import java.util.Set;

public class Fixture {
    public static Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    public static Lotto l2 = new Lotto(List.of(1, 2, 3, 34, 35, 36));
    public static Lotto l3 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
    public static List<Lotto> lottosList = List.of(l1, l2, l3);

    public static Set<Integer> winningNumber = Set.of(1, 2, 3, 4, 5, 6);
}

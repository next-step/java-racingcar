package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
    public static List<Integer> l1 = List.of(1, 2, 3, 4, 5, 6);
    public static List<Integer> l2 = List.of(1, 2, 3, 34, 35, 36);
    public static List<Integer> l3 = List.of(4, 5, 6, 7, 8, 9);
    public static List<List<Integer>> lottosList = List.of(l1, l2, l3);

    public static List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
}

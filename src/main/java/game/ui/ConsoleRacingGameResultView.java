package game.ui;

import java.util.Arrays;

public class ConsoleRacingGameResultView implements RacingGameResultView {

    private static final char FOOTPRINT = '-';

    @Override
    public void printRound(int round) {
        System.out.println(String.format("ROUND -%d-", round));
    }

    @Override
    public void printResult(int result) {
        char[] chars = new char[result];
        Arrays.fill(chars, FOOTPRINT);
        System.out.println(new String(chars));
    }
}

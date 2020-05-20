package game.ui;

import game.Car;

import java.util.Arrays;

public class ConsoleRacingGameResultView implements RacingGameResultView {

    private static final char FOOTPRINT = '-';

    @Override
    public void printRound(int round) {
        System.out.println(String.format("-ROUND %d-", round));
    }

    @Override
    public void printResult(Car car) {
        char[] chars = new char[car.getPosition()];
        Arrays.fill(chars, FOOTPRINT);
        System.out.println(String.format("%s : %s", car.getCarNameValue(), new String(chars)));
    }
}

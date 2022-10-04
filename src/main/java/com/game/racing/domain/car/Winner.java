package com.game.racing.domain.car;

public class Winner {

    private static Integer WINNER_POSITION = 0;

    public static Integer getWinnerPosition() {
        return WINNER_POSITION;
    }

    public static void compareWithWinnerPosition(int position) {
        if (position > WINNER_POSITION) {
            WINNER_POSITION = position;
        }
    }

    public static void resetWinnerPositionValue() {
        WINNER_POSITION = 0;
    }

}

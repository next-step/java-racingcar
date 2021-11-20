package domain;

public class Winner {
    private static final String COMMA_AND_SPACE = ", ";
    private static final String EMPTY = "";
    private static final int LAST_COMMA_LENGTH = 2;
    private static final int POSITION_MAX_START_NUMBER = 0;
    private final CarRaceGroup carRaceGroup;

    public Winner(CarRaceGroup carRaceGroup) {
        this.carRaceGroup = carRaceGroup;
    }

    public String findWinner() {
        int max = positionMax();

        String name = EMPTY;
        for (int i = 0; i < carRaceGroup.size(); i++) {
            name += winnerName(max, carRaceGroup.name(i), carRaceGroup.position(i));
        }

        return lastCommaRemove(name);
    }

    private String winnerName(int max, String name, int position) {
        if (max == position) {
            return name + COMMA_AND_SPACE;
        }
        return EMPTY;
    }

    private String lastCommaRemove(String name) {
        return name.substring(0, name.length() - LAST_COMMA_LENGTH);
    }

    public int positionMax() {
        int max = POSITION_MAX_START_NUMBER;

        int loopNumber = carRaceGroup.size();
        for (int i = 0; i < loopNumber; i++) {
            max = checkPositionMax(max, carRaceGroup.position(i));
        }
        return max;
    }

    private int checkPositionMax(int max, int position) {
        if (max < position) {
            return position;
        }
        return max;
    }
}

package racingcarwinnerrefactor;

import racingcarwinnerrefactor.util.MoveStrategy;
import racingcarwinnerrefactor.util.Strategy;

import java.util.Scanner;

public class Constants {

    public static final int RANDOM_MAX = 9;
    public static final int GO_MIN = 4;
    public static final int GO_MAX = 9;
    public static final int ADD = 1;
    public static final int WINNER_MIN_POSITION = 1;

    public static final String GO = "-";
    public static final String DELIMITER = ",";
    public static final String NAME_DELIMITER = " : ";
    public static final String NEXT_LINE = "\n";

    public static final Strategy moveStrategy = new MoveStrategy();
    public static final Scanner in = new Scanner(System.in);
}

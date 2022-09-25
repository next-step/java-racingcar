package domain;

import util.CommonUtil;
import view.ResultView;

import java.util.Random;

public class CarRace {

    public StringBuilder getResult(StringBuilder line) {
        if (CommonUtil.getRandomNumber() > 3) { return append(line); }
        return line;
    }

    public static StringBuilder append(StringBuilder line) {
        return line.append("-");
    }

}

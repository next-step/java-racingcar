package view;

import domain.CarRaceCount;
import domain.CarRaceGroup;
import domain.Winner;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEXT_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String EMPTY = "";
    private static final String CAR_RACE_RESULT_MESSAGE = "%s : %s \n";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void resultCarRace(CarRaceGroup carRaceGroup, CarRaceCount carRaceCount) {
        System.out.println(RESULT_MESSAGE);

        int loopCount = carRaceCount.count();
        for (int i = 0; i < loopCount; i++) {
            printCarPosition(carRaceGroup);
            System.out.print(NEXT_LINE);
        }
    }

    private static void printCarPosition(CarRaceGroup carRaceGroup) {
        int carRaceGroupSize = carRaceGroup.size();
        for (int i = 0; i < carRaceGroupSize; i++) {
            carRaceGroup.positionPlus(i);

            System.out.printf(CAR_RACE_RESULT_MESSAGE, carRaceGroup.name(i), changeNumberToHyphen(carRaceGroup.position(i)));
        }
    }

    private static String changeNumberToHyphen(int loopNumber) {
        String carLocation = EMPTY;
        for (int i = 0; i < loopNumber; i++) {
            carLocation += POSITION_MARK;
        }

        return carLocation;
    }

    public static void winner(CarRaceGroup carRaceGroup) {
        System.out.printf(WINNER_MESSAGE, Winner.winnerName(carRaceGroup));
        System.out.printf(NEXT_LINE);
    }

}

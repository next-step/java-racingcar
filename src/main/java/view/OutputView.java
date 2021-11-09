package view;

import domain.CarRaceGroup;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEXT_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String EMPTY = "";
    private static final String CAR_RACE_RESULT_MESSAGE = "%s : %s \n";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final int CRITERIA_CAR_NAME_INDEX = 0;

    public static void result(CarRaceGroup carRaceGroup) {
        System.out.println(RESULT_MESSAGE);

        int carRaceGroupSize = carRaceGroup.size();
        String criteriaCarName = carRaceGroup.carName(CRITERIA_CAR_NAME_INDEX);
        for (int i = 0; i < carRaceGroupSize; i++) {
            printNextLine(i, criteriaCarName, carRaceGroup.carName(i));
            System.out.printf(CAR_RACE_RESULT_MESSAGE, carRaceGroup.carName(i), changeNumberToHyphen(carRaceGroup.carPosition(i)));
        }
        System.out.println(NEXT_LINE);
    }

    public static void winner(CarRaceGroup carRaceGroup) {
        System.out.printf(WINNER_MESSAGE, carRaceGroup.winner());
    }

    private static String changeNumberToHyphen(int loopNumber) {
        String carLocation = EMPTY;
        for (int i = 0; i < loopNumber; i++) {
            carLocation += POSITION_MARK;
        }

        return carLocation;
    }

    private static void printNextLine(int index, String criteriaCarName, String carName) {
        if (index != 0 && criteriaCarName == carName) {
            System.out.print(NEXT_LINE);
        }
    }

}

package race.car;

import java.util.ArrayList;
import java.util.List;

/**
 * 결과를 그려주는 객체
 */
public class RaceResultPrint {

    public static void runPrintRaceResult(CarRaceInfo carRaceInfo) {
        List<List<CarRaceMoveInfo>> carReacMoveInfoList = new ArrayList<>();

        for (String name : carRaceInfo.getRaceCarNames()) {
            carReacMoveInfoList.add(carRaceInfo.getCarReacMoveInfoList().get(name));
        }
        printPaceResult(carReacMoveInfoList, carRaceInfo.getRaceTryCount());
    }

    private static void printPaceResult(List<List<CarRaceMoveInfo>> carReacMoveInfoList, int raceTryCount) {
        for (int i = 0; i < raceTryCount; i++) {
            repeatCarReacMoveInfoList(carReacMoveInfoList, i);
            System.out.print(System.lineSeparator());
        }
    }

    private static void repeatCarReacMoveInfoList(List<List<CarRaceMoveInfo>> carReacMoveInfoList, int index) {
        for (int i = 0; i < carReacMoveInfoList.size(); i++) {
            System.out.print(carReacMoveInfoList.get(i).get(index).getRaceCarName()
                            + " : "
                            + changeNumberToChar(carReacMoveInfoList.get(i).get(index).getMoveDistance()));
            System.out.print(System.lineSeparator());
        }
    }

    private static String changeNumberToChar(int count) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
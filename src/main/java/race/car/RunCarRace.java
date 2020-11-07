package race.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RunCarRace {

    private static String INPUT_CAR_RACE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    public static void start() {
        System.out.println(INPUT_CAR_RACE_NAMES);
        String[] raceCarNames = InputCarData.checkName(InputCarData.inputValue());
        System.out.println(HOW_MANY_ATTEMPTS);
        int raceTryCount = InputCarData.checkTryCount(InputCarData.inputValue());

        RaceResultPrint.runPrintRaceResult(new CarRaceInfo(raceCarNames, runRace(raceCarNames, raceTryCount), raceTryCount));
    }

    /**
     * 경주
     *
     * @param raceCarNames
     * @param raceTryCount
     * @return
     */
    public static HashMap<String, List<CarRaceMoveInfo>> runRace(String[] raceCarNames, int raceTryCount) {
        HashMap<String, List<CarRaceMoveInfo>> returnCarReacInfoMap = new HashMap<>();

        for (String carName : raceCarNames) {
            returnCarReacInfoMap.put(carName, carRaceMove(raceTryCount, carName));
        }

        return returnCarReacInfoMap;
    }

    /**
     * 자동차 레이스 결과를 기록하기
     *
     * @param raceTryCount
     * @param carName
     */
    private static List<CarRaceMoveInfo> carRaceMove(int raceTryCount, String carName) {
        CarRaceMoveInfo carRaceMoveInfo;
        List<CarRaceMoveInfo> carRaceMoveInfoList = new ArrayList<>();

        // 첫 레이스일때
        if (carRaceMoveInfoList.size() == 0) {
            carRaceMoveInfo = new CarRaceMoveInfo(carName, Car.moveCarCheck(0, Car.getMovePower()));
            carRaceMoveInfoList.add(carRaceMoveInfo);
        }

        // 두번재레이스 이후
        for (int i = 1; i < raceTryCount; i++) {
            carRaceMoveInfo = new CarRaceMoveInfo(carName, Car.moveCarCheck(carRaceMoveInfoList.get(i - 1).getMoveDistance(), Car.getMovePower()));
            carRaceMoveInfoList.add(carRaceMoveInfo);
        }
        return carRaceMoveInfoList;
    }


}

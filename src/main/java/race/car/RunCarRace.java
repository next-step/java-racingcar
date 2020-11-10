package race.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RunCarRace {

    private static String INPUT_CAR_RACE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    private static Random random = new Random();
    private static HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList;
    private static String[] raceCarNames;
    private static int raceTryCount;

    public RunCarRace(HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList, String[] raceCarNames, int raceTryCount) {
        this.carReacMoveInfoList = carReacMoveInfoList;
        this.raceCarNames = raceCarNames;
        this.raceTryCount = raceTryCount;
    }

    public RunCarRace() {

    }

    public void start() {
        RaceResultPrint raceResultPrint = new RaceResultPrint();
        System.out.println(INPUT_CAR_RACE_NAMES);
        raceCarNames = InputCarData.checkName(InputCarData.inputValue());
        System.out.println(HOW_MANY_ATTEMPTS);
        raceTryCount = InputCarData.checkTryCount(InputCarData.inputValue());
        runRace(raceCarNames, raceTryCount);

        raceResultPrint.runPrintRaceResult(new RunCarRace(runRace(raceCarNames, raceTryCount),
                raceCarNames,
                raceTryCount));
    }

    /**
     * 경주
     *
     * @param raceCarNames
     * @param raceTryCount
     * @return
     */
    public HashMap<String, List<CarRaceMoveInfo>> runRace(String[] raceCarNames, int raceTryCount) {
        HashMap<String, List<CarRaceMoveInfo>> returnCarReacMoveInfoLMap = new HashMap<>();
        for (String carName : raceCarNames) {
            returnCarReacMoveInfoLMap.put(carName, carRaceMove(raceTryCount, carName));
        }

        return returnCarReacMoveInfoLMap;
    }

    /**
     * 자동차 레이스 결과를 기록하기
     *
     * @param raceTryCount
     * @param carName
     */
    private List<CarRaceMoveInfo> carRaceMove(int raceTryCount, String carName) {
        CarRaceMoveInfo carRaceMoveInfo;
        List<CarRaceMoveInfo> carRaceMoveInfoList = new ArrayList<>();

        // 첫 레이스일때
        if (carRaceMoveInfoList.size() == 0) {
            carRaceMoveInfo = new CarRaceMoveInfo(carName, Car.moveCarCheck(0, random.nextInt(10)));
            carRaceMoveInfoList.add(carRaceMoveInfo);
        }

        // 두번재레이스 이후
        for (int i = 1; i < raceTryCount; i++) {
            carRaceMoveInfo = new CarRaceMoveInfo(carName, getMoveDistance(carRaceMoveInfoList.get(i - 1)));
            carRaceMoveInfoList.add(carRaceMoveInfo);
        }
        return carRaceMoveInfoList;
    }

    public List<List<CarRaceMoveInfo>> carReacMoveInfoList(RunCarRace runCarRace) {
        List<List<CarRaceMoveInfo>> returnCarReacMoveInfoList = new ArrayList<>();
        HashMap<String, List<CarRaceMoveInfo>> paramCarRaceMoveInfo = runCarRace.getCarReacMoveInfoList();
        String[] paramRaceCarNames = runCarRace.getRaceCarNames();

        for (String carName : paramRaceCarNames) {
            returnCarReacMoveInfoList.add(paramCarRaceMoveInfo.get(carName));
        }
        return returnCarReacMoveInfoList;
    }

    public List<CarRaceMoveInfo> lastCarRecord(RunCarRace runCarRace) {
        List<CarRaceMoveInfo> returnValue = new ArrayList<>();
        for (String carName : runCarRace.getRaceCarNames()) {
            returnValue.add(runCarRace.getCarReacMoveInfoList().get(carName).get(runCarRace.getCarReacMoveInfoList().get(carName).size() - 1));
        }

        return returnValue;
    }

    /**
     * 랜덤값 return
     *
     * @return
     */
    public int getMovePower() {
        return random.nextInt(10);
    }

    public String[] getRaceCarNames() {
        return raceCarNames;
    }

    public HashMap<String, List<CarRaceMoveInfo>> getCarReacMoveInfoList() {
        return carReacMoveInfoList;
    }

    public int getRaceTryCount() {
        return raceTryCount;
    }

    public int getMoveDistance(CarRaceMoveInfo carRaceMoveInfo) {
        int movePower = getMovePower();
        int moveDiatance = carRaceMoveInfo.getMoveDistance();

        return Car.moveCarCheck(moveDiatance, movePower);
    }
}

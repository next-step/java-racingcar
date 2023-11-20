package motorRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static motorRace.InputView.systemIn;
import static motorRace.ResultView.systemOut;

public class MotorRaceApplication {

    private static final String CAR_CNT_INPUT_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_CNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MSG = "실행 결과";

    private static final int MOVE_CONSTANT = 4;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int carCnt = systemIn(CAR_CNT_INPUT_MSG);

        List<RacingCar> racingCarList = new ArrayList<>();
        makeRacingCars(racingCarList, carCnt);

        int moveCnt = systemIn(MOVE_CNT_INPUT_MSG);
        systemOut(RESULT_MSG);
        raceStart(racingCarList, moveCnt);
    }

    public static List<RacingCar> makeRacingCars(List<RacingCar> racingCarList, int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            racingCarList.add(new RacingCar());
        }
        return racingCarList;
    }

    public static List<RacingCar> raceStart(List<RacingCar> racingCarList, int moveCnt) {
        for (int i = 0; i < moveCnt; i++) {
            oneStepResult(oneStepRace(racingCarList));
        }
        return racingCarList;
    }

    public static List<RacingCar> oneStepRace(List<RacingCar> racingCarList) {
        racingCarList.forEach(racingCar -> {
            condition(racingCar, random.nextInt(10), MOVE_CONSTANT);
        });
        return racingCarList;
    }

    public static RacingCar condition(RacingCar racingCar, int randomValue, int constantValue) {
        if (randomValue >= constantValue) {
            racingCar.move();
        }
        return racingCar;
    }

    public static List<RacingCar> oneStepResult(List<RacingCar> racingCarList) {
        racingCarList.forEach(ResultView::systemOut);
        systemOut("");
        return racingCarList;
    }
}

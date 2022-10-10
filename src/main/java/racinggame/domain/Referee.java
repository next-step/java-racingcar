package racinggame.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Referee {
    public static final String CAR_NAME_SPLITTER = ",";

    public void startGame() {
        String[] carNames = getCarNames();
        int count  = getCount();
        RacingCar racingCar = new RacingCar();
        racingCar.racingStart(carNames, count);
    }

    private int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(getInputCountAfterCheck());
    }

    private String getInputCountAfterCheck() {
        String count;
        boolean isInvalidCount;
        do {
            count = readLine();
            isInvalidCount = isInvalidCount(count);
            System.out.println();
        } while (isInvalidCount);
        return count;
    }

    private boolean isInvalidCount(String count) {
        boolean isInvalidCount = false;
        try {
            checkCount(count);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 0보다 큰 숫자여야 한다.");
            isInvalidCount = true;
        }
        return isInvalidCount;
    }

    private String[] getCarNames() {
        String inputCarNameString;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        boolean isInvalidCarName;
        do {
            inputCarNameString = readLine();
            isInvalidCarName = isInvalidCarName(inputCarNameString);
        } while (isInvalidCarName);
        return inputCarNameString.split(CAR_NAME_SPLITTER);
    }

    private boolean isInvalidCarName(String inputCarNameString) {
        boolean isInvalidCarName = false;
        try {
            checkCarNames(inputCarNameString);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름 입력이 잘못 되었습니다.");
            isInvalidCarName = true;
        }
        return isInvalidCarName;
    }

    public void checkCarNames(String inputCarNameString) {
        try {
            String[] carNames = inputCarNameString.split(CAR_NAME_SPLITTER);
            for (String carName : carNames) {
                checkCarNameLength(carName);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCount(String inputCount) {
        try {
            int count = Integer.parseInt(inputCount);
            if (count < 1) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

package racinggame.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    private final Map<String, String> racing = new LinkedHashMap<>();

    private void addCar(String[] carNames) {
        for (String carName : carNames) {
            this.racing.put(carName, "");
        }
    }

    private void printRacing() {
        racing.forEach((carName, result) -> {
            System.out.println(carName + " : " + result);
        });
        System.out.println();
    }

    public void racingStart(String[] carNames, int count) {
        System.out.println("실행 결과");
        addCar(carNames);
        race(count);
    }


    private void race(int count) {
        int winnerLength = 0;
        for (int i = 0; i < count; i++) {
            for (String carName : racing.keySet()) {
                winnerLength = goFront(winnerLength, carName);
            }
            printRacing();
        }
        printWinner(winnerLength);

    }

    private int goFront(int winnerLength, String carName) {
        if (pickNumberInRange(0, 9) >= 4) {
            racing.put(carName, racing.get(carName) + "-");
            if (racing.get(carName).length() > winnerLength) {
                winnerLength = racing.get(carName).length();
            }
        }
        return winnerLength;
    }

    private void printWinner(int winnerLength) {
        System.out.println("winnerLength = " + winnerLength);
        List<String> result = new ArrayList<>();
        for (String carName : racing.keySet()) {
            if (racing.get(carName).length() == winnerLength) {
                result.add(carName);
            }
        }
        System.out.print("최종 우승자 :");
        System.out.println(String.join(",", result));
    }
}

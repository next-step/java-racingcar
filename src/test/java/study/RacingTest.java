package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

public class RacingTest {

    int random = 0;
    int count = 0;
    HashMap<String, String> hash = new HashMap<String, String>();
    ArrayList<String> winner = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    @ParameterizedTest
    @ValueSource(ints = {1,3,4,5}, strings = {"testCar"})
    void isMove(int random, String carName) {
        if ((random >= 4) && hash.get(carName) == null) {
            hash.put(carName, "-");
            return;
        }
        if (random >= 4) {
            hash.put(carName, hash.get(carName) + "-");
            return;
        }
        hash.put(carName, hash.get(carName) + "");
    }

    /**
     * 화면에 현황 표시 메서
     */
    void display(String[] cars) {
        for (String carName : cars) {
            System.out.println(carName + ":" + hash.get(carName));
        }
    }

    /**
     * 승자 정하는 메서
     */
    void win(String[] cars) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String carName : cars) {
            result.put(carName, hash.get(carName).length());
        }
        int maxValueInMap = Collections.max(result.values());
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                winner.add(entry.getKey());
            }
        }
    }
}

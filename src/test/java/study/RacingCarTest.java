package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("scanner 동작 테스트")
    void scannerTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        assertThat(inputValue).isEqualTo("1");
    }

    @Test
    @DisplayName("Random 함수를 사용해 0-9 숫자 반환 테스트")
    void getRandom0To9NumberTest() {
        Random random = new Random();
        int randomNumber = getRandom0To9Number(random);
        System.out.println("randomNumber = " + randomNumber);
    }

    private static int getRandom0To9Number(Random random) {
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    @Test
    @DisplayName("0-3의 랜덤 숫자인 경우 멈춤, 4-9의 랜덤 숫자가 나오는 경우 전진한다.")
    void goOrStopTest() {
        Random random = new Random();
        int randomNumber = getRandom0To9Number(random);
        if (randomNumber >= 4) {
            System.out.println("randomNumber = " + randomNumber + " >> go!!");
        } else {
            System.out.println("randomNumber = " + randomNumber + " >> stop");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = "3,4")
    @DisplayName("자동차와 이동 횟수를 입력받고 경기 결과를 출력한다.")
    void arrayList_GoOrStop_Test(String input) {
        String[] strings = input.split(",");
        int carCount = Integer.parseInt(strings[0]);
        int raceCount = Integer.parseInt(strings[1]);

        Random random = new Random();
        ArrayList<String>[] raceList = getArrayLists(carCount);
        int randomNumber = 0;
        for (int i = 0; i < raceCount; i++) {
            for (ArrayList<String> car : raceList) {
                randomNumber = getRandom0To9Number(random);
                if (randomNumber >= 4) {
                    car.add("-");
                }
            }
            printResult(raceList);
        }
    }

    private static ArrayList<String>[] getArrayLists(int carCount) {
        ArrayList<String>[] raceList = new ArrayList[carCount];

        for (int i = 0; i < carCount; i++) {
            raceList[i] = new ArrayList<String>();
        }
        return raceList;
    }

    private static void printResult(ArrayList<String>[] raceList) {
        for (List<String> raceResult : raceList) {
            for (int i = 0; i < raceResult.size(); i++) {
                System.out.print(raceResult.get(i));
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

package racing;


import static racing.InputView.inputData;
import static racing.ResultView.outputPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RacingCar {

    private static final String inputCar = "car";
    private static final String inputRacingCount = "racingCount";

    public static void Race() {
        //UI 및 Input값 받기
        Map<String, Integer> input = inputData();

        startRacing(input);
    }

    //자동차 댓수로 List 생성
    public static List<Integer> makeRacing(Integer car) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < car; i++) {
            result.add(1);
        }

        return result;
    }

    //횟수당 레이싱 시작 메서드
    public static void startRacing(Map<String, Integer> inputData) {

        List<Integer> carCountingList = makeRacing(inputData.get(inputCar));

        for (int i = 0; i < inputData.get(inputRacingCount); i++) {
            outputPrint(carCountingList);
            carCountingList = addCount(carCountingList);
        }
    }

    //횟수당 전진을 하는 것에 대한 메서드
    public static List<Integer> addCount(List<Integer> racingCountData) {
        List<Integer> result = new ArrayList<>();
        for (Integer data : racingCountData) {
            data = data + checkRandomData();
            result.add(data);
        }
        return result;
    }

    //랜덤값을 통한 전진여부 메서드
    public static int checkRandomData() {
        Random random = new Random();
        int randomData = random.nextInt(10);

        if (randomData >= 4) {
            return 1;
        }
        return 0;
    }
}
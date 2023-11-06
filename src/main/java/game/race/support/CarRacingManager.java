package game.race.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import game.race.Car;
import game.race.model.InputView;
import game.race.model.ResultView;

public class CarRacingManager {

    private static final String ASK_VEHICLE_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String SHOW_RESULT = "실행 결과";
    private static final String MARK = "-";

    private static final Scanner scanner = new Scanner(System.in);

    public static InputView showPrompt() {
        System.out.println(ASK_VEHICLE_COUNT);
        String val1 = scanner.nextLine();
        checkInput(val1);

        System.out.println(ASK_TRY_COUNT);
        String val2 = scanner.nextLine();
        checkInput(val2);

        InputView inputView = new InputView();
        inputView.setVehicleCnt(Integer.parseInt(val1));
        inputView.setTryCnt(Integer.parseInt(val2));

        return inputView;
    }

    public static void checkInput(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("값을 입력 하세요.");
        }

        if (number == 0) {
            throw new IllegalArgumentException("0보다 큰 수를 넣어 주세요.");
        }
    }

    public static void showResult(ResultView resultView) {
        System.out.println(SHOW_RESULT);
        Map<Integer, List<String>> results = resultView.getResults();
        for (int key : results.keySet()) {
            printMark(results.get(key));
            System.out.println(resultView.markEnd());
        }
    }

    private static void printMark(List<String> tireMarks) {
        for (String mark : tireMarks) {
            System.out.println(mark);
        }
    }

    public static ResultView start(InputView inputView) {
        ResultView resultView = new ResultView();
        for (int trial = 0; trial < inputView.getTryCnt(); trial++) {
            Car car = new Car();
            car.setCars(inputView.getVehicleCnt());
            List<Boolean> movements = car.goForward();

            resultView.setNewTireMarks(getIdx(trial),
                                       getResult(trial, movements, resultView));
        }

        return resultView;
    }

    private static int getIdx(int trial) {
        return trial + 1;
    }

    public static List<String> getResult(int trial,
                                         List<Boolean> movements,
                                         ResultView resultView) {
        List<String> newTireMarks = new ArrayList<>();
        List<String> tireMarks = resultView.getTireMarks(trial);
        if (tireMarks == null) {
            return getDefaultMarks(newTireMarks, movements);
        }

       return getMarks(tireMarks, newTireMarks, movements);
    }

    private static List<String> getDefaultMarks(List<String> newTireMarks,
                                                List<Boolean> movements) {
        for (int carIdx = 0; carIdx < movements.size(); carIdx++) {
            newTireMarks.add(MARK);
        }

        return newTireMarks;
    }

    private static List<String> getMarks(List<String> tireMarks,
                                         List<String> newTireMarks,
                                         List<Boolean> movements) {
        for (int carIdx = 0; carIdx < movements.size(); carIdx++) {
            String mark = tireMarks.get(carIdx);
            newTireMarks.add(append(movements, carIdx, mark));
        }

        return newTireMarks;
    }

    private static String append(List<Boolean> movements,
                                 int carIdx,
                                 String mark) {
        if (movements.get(carIdx)) {
            return mark.concat(MARK);
        }

        return mark;
    }
}

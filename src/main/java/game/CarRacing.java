package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    private static final String SCRIPT_ONE = "자동차 대수는 몇 대 인가요?";
    private static final String SCRIPT_TWO = "시도할 회수는 몇 회 인가요?";
    private static final String LAST_SCRIPT = "실행 결과";
    private static final String MARK = "-";
    private static final String END_MARK = "";
    private static final int THRESHOLD = 4;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        showPrompt(inputView);

        int tryCnt = inputView.getTryCnt();
        int vehicleCnt = inputView.getVehicleCnt();
        resultView.setTireMarks(startRace(tryCnt, vehicleCnt));

        showResult(resultView);
    }

    public static List<String> startRace(int tryCnt, int vehicleCnt) {
        List<String> tireMarks = new ArrayList<>();
        for (int attemptCnt = 0; attemptCnt < tryCnt; attemptCnt++) {
            tireMarks.addAll(goForward(tryCnt, vehicleCnt));
        }

        return tireMarks;
    }

    private static List<String> goForward(int tryCnt, int vehicleCnt) {
        List<String> marks = new ArrayList<>();
        for (int vehivleIdx = 0; vehivleIdx < vehicleCnt; vehivleIdx++) {
            marks.add(getMarks(tryCnt));
        }

        marks.add(END_MARK);
        return marks;
    }

    private static String getMarks(int tryCnt) {
        StringBuilder builder = new StringBuilder();
        builder.append(MARK);
        for (int idx = 0; idx < tryCnt; idx++) {
            int number = new Random().nextInt(9) + 1;
            append(builder, number);
        }

        return builder.toString();
    }

    public static void append(StringBuilder builder, int number) {
        if (THRESHOLD < number) {
            builder.append(MARK);
        }
    }

    private static void showResult(ResultView resultView) {
        System.out.println(LAST_SCRIPT);
        for (String tireMark : resultView.getTireMarks()) {
            System.out.println(tireMark);
        }
    }

    private static void showPrompt(InputView inputView) {
        System.out.println(SCRIPT_ONE);
        String val1 = scanner.nextLine();
        checkInput(val1);

        System.out.println(SCRIPT_TWO);
        String val2 = scanner.nextLine();
        checkInput(val2);

        inputView.setVehicleCnt(Integer.parseInt(val1));
        inputView.setTryCnt(Integer.parseInt(val2));
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

    public static class InputView {

        private int vehicleCnt;

        private int tryCnt;

        public int getVehicleCnt() {
            return vehicleCnt;
        }

        public void setVehicleCnt(int vehicleCnt) {
            this.vehicleCnt = vehicleCnt;
        }

        public int getTryCnt() {
            return tryCnt;
        }

        public void setTryCnt(int tryCnt) {
            this.tryCnt = tryCnt;
        }
    }

    public static class ResultView {

        private final List<String> tireMarks = new ArrayList<>();

        public List<String> getTireMarks() {
            return tireMarks;
        }

        public void setTireMarks(List<String> tireMarks) {
            this.tireMarks.addAll(tireMarks);
        }
    }
}

package racingcar.controller;


import java.util.List;

public class ResultView {


    private ResultView() {

    }

    public static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }


    public void printRacingCarsStatus(List<Integer> racingCarsPosition) {
        StringBuilder sb = new StringBuilder();
        for (Integer position : racingCarsPosition) {
            sb.append(getPosition(position));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String getPosition(Integer position) {
        return "-".repeat(position);
    }
}

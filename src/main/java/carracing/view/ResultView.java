package carracing.view;

import carracing.Car;

public class ResultView {
    private static final String MOVE_MARK = "-";
    private String result = "";

    public String getResult() {
        return result;
    }

    public void print(int step) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < step; i++) {
            this.result = builder.append(MOVE_MARK).toString();
        }
        System.out.println(getResult());
    }
}

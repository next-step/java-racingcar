package step3.view;

import step3.Constant;

public class ResultView implements View<StringBuilder> {
    private static final ResultView resultView = new ResultView();
    private StringBuilder racingProgress = new StringBuilder();

    private ResultView() {
        System.out.println(Constant.CREATED_INSTANCE);
    }

    public static ResultView getInstance() {
        return resultView;
    }

    @Override
    public void execute(StringBuilder sb) {
        if (racingProgress.length() > 0) {
            racingProgress.delete(0, racingProgress.length());
        }
        racingProgress = sb;
        this.execute();
    }

    @Override
    public StringBuilder execute() {
        System.out.println(racingProgress.toString());
        return racingProgress;
    }
}

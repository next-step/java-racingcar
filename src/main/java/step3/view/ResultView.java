package step3.view;

import step3.domain.Racing;

public class ResultView {

    private static final String MARK = "-";
    private Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }


    public void resultOutput() {

        for (int i = 0; i < racing.getAttemptNumber(); i++) {
            this.racing.racingRule();

            this.racing.getCars().getCars()
                    .forEach(car -> {
                        markOutput(car.getDistance());
                    });
        }


    }

    private void markOutput(int distance) {
        String resultMark = "-";

        for (int i = 0; i < distance; i++) {
            resultMark = resultMark + MARK;
        }

        System.out.println(resultMark);
    }

}

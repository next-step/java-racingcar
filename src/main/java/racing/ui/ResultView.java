package racing.ui;

import racing.domain.Competition;

public class ResultView {
    public static void print(final Competition competition) {
        System.out.println("실행 결과");

        competition.progressCompetition();
    }
}

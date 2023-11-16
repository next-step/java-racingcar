package carracing;

public class ResultView {

    private final String POSITION_MARKER = "-";
    private static ResultView instance;

    public void showResultComment(int position) {
        System.out.println(POSITION_MARKER.repeat(position));
    }

    public void showRacingGameResultComment() {
        System.out.println("실행결과");
    }

    public void showRacingRoundEndComment() {
        System.out.print("\n");
    }

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

}

package racingGame;

public class Position {

    private static final String VIEW_TEXT = "-";
    private int position;

    public Position() {
        this.position = 0;
    }

    public void add() {
        position++;
    }

    public String getView() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append(VIEW_TEXT);
        }
        return result.toString();
    }
}

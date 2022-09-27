package score;

public class Score {
    private static int score = 0;

    public void run() {
        score += 1;
    }

    public int getScore() {
        return score;
    }
}

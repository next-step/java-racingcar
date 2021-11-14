package Racing.score;

import Racing.stage.Stage;

import java.util.Random;

public class Score {

    static final private String DISPLAY_TOKEN = "-";
    static final private int RANDOM_BOUND = 10;

    private final Stage stage;
    private final int value;

    public Score(Stage stage) {
        this(stage, Score.getRandomToken());
    }

    public Score(Stage stage, int value) {
        this.stage = stage;
        this.value = value;
    }

    public static int getRandomToken() {
        return new Random().nextInt(RANDOM_BOUND) + 1;
    }

    public String showDisplay() {
        return DISPLAY_TOKEN.repeat(value);
    }
}

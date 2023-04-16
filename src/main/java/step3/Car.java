package step3;

import java.util.List;

public class Car {

    private int progress = 0;

    public void move(int random) {
        if (moveAvailable(random)) {
            progress++;
        }
    }

    public static boolean moveAvailable(int random) {
        return random >= 4;
    }

    public int getProgress() {
        return this.progress;
    }

    public void addScore(List<Integer> scoreList) {
        scoreList.add(this.progress);
    }


}

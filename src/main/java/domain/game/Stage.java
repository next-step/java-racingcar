package domain.game;

public class Stage {
    private final int totalStage;
    private int currentStage;

    public Stage(int totalStage) {
        this.totalStage = totalStage;
    }

    public static Stage from(int totalStage) {
        return new Stage(totalStage);
    }

    public boolean hasNext() {
        return totalStage > currentStage;
    }

    public void next() {
        if(hasNext()) {
            currentStage++;
        }
    }
}

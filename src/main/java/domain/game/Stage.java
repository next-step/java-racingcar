package domain.game;

public class Stage {
    private final int totalStage;
    private int currentStage;

    public Stage(int totalStage) {
        if(totalStage < 0) {
            throw new IllegalArgumentException("음수값은 허용되지 않습니다.");
        }
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

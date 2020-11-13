package study.step4;

public class Car {
    private String name;
    private int score = 0;
    private int totalScore = 0;

    public Car(String name) {
        this.name = name;
    }

    /* 전진 여부 로직 */
    public void go (int number) {
        if (number >= 4) {
            this.score++;
            this.totalScore++;
        }
    }

    // 스코어 초기화
    public void initScore() {
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int getTotalScore() {
        return this.totalScore;
    }
}

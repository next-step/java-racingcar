package study.step5.domain;

public class Car {
    private String name;
    private int score = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차이름 길이가 초과되었습니다.");
        }
        this.name = name;
    }

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /* 전진 여부 로직 */
    public void go (int number) {
        if (number >= 4) {
            this.score++;
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
}

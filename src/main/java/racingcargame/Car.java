package racingcargame;

public class Car {
    private final String name;
    private int score; //현재점수
    private String printScore; //출력스코어

    public Car(final String name) {
        this.name = name;
        this.printScore = "";
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore() {
        this.score++;
        printScore += "-";
    }

    public String getName() {
        return this.name;
    }

    public String getPrintScore() {
        return printScore;
    }
}
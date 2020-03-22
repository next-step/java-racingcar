package step3;

public class Round {
    private int time;               // 회차 정보
    private int randomNumber;       // 회차별 랜덤 수
    private int position;           // 해당 회차의 position 정보

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

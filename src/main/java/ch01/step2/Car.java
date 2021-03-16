package ch01.step2;

/**
 * Car 객체
 * -이름
 * -진행숫자
 * -진행바
 */
public class Car {
    String name;
    int progressCnt;
    String progressBar ;

    Car() {
        this.progressBar = new String();
    }

    public Car(String name) {
        this.name = name;
        this.progressBar = new String();
    }

    public void move() {
        progressCnt++;
        progressBar += "-";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgressCnt(int progressCnt) {
        this.progressCnt = progressCnt;
    }

    public void setProgressBar(String progressBar) {
        this.progressBar = progressBar;
    }

    public String getProgressBar() {
        return progressBar;
    }

    public int getProgressCnt() {
        return progressCnt;
    }


}

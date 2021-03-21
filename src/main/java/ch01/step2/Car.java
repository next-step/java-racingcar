package ch01.step2;

/**
 * Car 객체
 * -이름
 * -진행숫자
 * -진행바
 */
public class Car {
    private String name;
    private int progressCnt;

    public Car(String name) {
        this.name = name;
        progressCnt++;
    }

    public void move() {
        progressCnt++;
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

    public int getProgressCnt() {
        return progressCnt;
    }

    @Override
    public String toString() {
        String progressBar = new String();
        for(int i=0;i<progressCnt;i++){
            progressBar +="-";
        }
        return progressBar;
    }
}

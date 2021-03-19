package ch01.racinggame.Domain;

public class Car {
    static final int initCarCount = 1;
    static final int limitNameLength = 5;
    private String name;
    private int progressCnt;

    public Car(String name) {
        this.name = name;
        progressCnt = initCarCount;
    }

    public void move() {
        progressCnt++;
    }

    public String name() {
        return name;
    }

    public int progressCnt() {
        return progressCnt;
    }

    @Override
    public String toString() {
        String progressBar = new String();
        for (int i = 0; i < progressCnt; i++) {
            progressBar += "-";
        }
        return progressBar;
    }

    private void checkNameLength(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("빈칸을 입력할수 없습니다.");
        }

        if (name != null && name.length() > limitNameLength) {
            throw new IllegalArgumentException(limitNameLength + "글자를 초과할 수 없습니다. ");
        }
    }
}

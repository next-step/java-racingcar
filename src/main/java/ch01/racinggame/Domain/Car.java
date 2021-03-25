package ch01.racinggame.Domain;


public class Car implements Comparable<Car> {

    private static final int initCarCount = 1;
    private static final int limitNameLength = 5;
    private final String name;
    private int progressCnt;

    public Car(String name) {
        checkNameLength(name);
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

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.progressCnt(), this.progressCnt);

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

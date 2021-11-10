package racingcar.domain;

public class CountInfo {

    private final int count;

    public CountInfo(int count) {
        invalidInputCheck(count);
        this.count = count;
    }

    private void invalidInputCheck(int count){
        if(count < 0) throw new IllegalArgumentException("입력 값은 0보다 커야합니다.");
    }

    public int get() {
        return this.count;
    }
}
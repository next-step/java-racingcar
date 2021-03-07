package step3.domain;

/**
 * 자동차 경주 기록을 저장할 클래스
 */
public class Record {
    private final int position;

    private Record(Builder builder) {
        this.position = builder.position;
    }

    public int getPosition() {
        return position;
    }

    // set 대신 Builder 패턴을 이용해본다.
    public static class Builder {
        private int position;

        public Builder position(int position) {
            this.position = position;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}

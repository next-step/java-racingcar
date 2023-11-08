package car_racing;

public class InputView {
    private int number;
    private int count;

    public int number() {
        return this.number;
    }

    public int count() {
        return count;
    }

    private InputView(Builder builder) {
        this.number = builder.number;
        this.count = builder.count;
    }

    public static class Builder {
        private int number;
        private int count;

        public Builder() {
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public  InputView build() {
            return new InputView(this);
        }
    }
}

package step2;

public class Formula {

    private MyNumber first;
    private MyNumber second;
    private String operator;

    private Formula(Builder builder) {
        this.first = builder.first;
        this.second = builder.second;
        this.operator = builder.operator;
    }

    public MyNumber getFirst() {
        return first;
    }

    public MyNumber getSecond() {
        return second;
    }

    public String getOperator() {
        return operator;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private MyNumber first;
        private MyNumber second;
        private String operator;

        private Builder() {}

        public Builder setFirst(MyNumber first) {
            this.first = first;
            return this;
        }

        public Builder setSecond(MyNumber second) {
            this.second = second;
            return this;
        }

        public Builder setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Formula build() {
            return new Formula(this);
        }
    }
}

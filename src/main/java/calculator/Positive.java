package calculator;

public class Positive {
    private final int number;

    public Positive(String target) {
        this.number = Integer.parseInt(target);
        if(this.number < 0) {
            throw new RuntimeException("양수만 가능합니다.");
        }
    }

    public Positive(int number) {
        if(number < 0) {
            throw new RuntimeException("양수만 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Positive)) {
            return false;
        }
        Positive target = (Positive) o;
        return this.number == target.number;
    }

    public int plus(int i) {
        return this.number + i;
    }

    public int plus(Positive positive) {
        return this.number + positive.number;
    }
}

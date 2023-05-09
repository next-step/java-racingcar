package domain;

public class SameNumberGenerator implements NumberGenerator{
    int value;

    SameNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return value;
    }
}

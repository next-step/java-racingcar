package step3.domain;

public class RandomNumber0by10 implements RandomNumber {
    @Override
    public int make() {
        return (int) (Math.random() * 10);
    }
}

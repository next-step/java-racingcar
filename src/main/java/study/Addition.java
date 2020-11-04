package study;

public class Addition implements Operator{

    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}

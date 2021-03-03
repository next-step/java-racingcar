package step02;

public class Calculations implements RuleCalculations {

    @Override
    public int sum(int first, int second) {
        return first + second;
    }

    @Override
    public int num(int first, int second) {
        return first - second;
    }

    @Override
    public int multi(int first, int second) {
        return first * second;
    }

    @Override
    public int div(int first, int second) {
        return first / second;
    }
}

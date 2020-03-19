package study.calculator;

public class Operator {
    public Integer plus(Integer leftSide, Integer rightSide) {
        return leftSide + rightSide;
    }

    public Integer minus(Integer leftSide, Integer rightSide) {
        return leftSide - rightSide;
    }

    public Integer divide(Integer leftSide, Integer rightSide) {
        if(rightSide == 0) {
            throw new IllegalArgumentException();
        }
        return leftSide / rightSide;
    }

    public Integer multiply(Integer leftSide, Integer rightSide) {
        return leftSide * rightSide;
    }
}

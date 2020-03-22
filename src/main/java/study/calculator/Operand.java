package study.calculator;

public class Operand {
    private float leftSide;
    private float rightSide;

    public Operand(float leftSide, float rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public float getLeftSide() {
        return leftSide;
    }

    public float getRightSide() {
        return rightSide;
    }
}

package study;

public class SeparatedOperands {
    private final String[] operands;

    public SeparatedOperands(String delimiterRegex, String separatedString) {
        operands = separatedString.split(delimiterRegex);
    }

    public int[] getPositiveOperands() {
        int[] positiveOperands = new int[getOperandsLength()];
        for (int i = 0; i < getOperandsLength(); i++) {
            positiveOperands[i] = getPositiveOperand(operands[i]);
        }

        return positiveOperands;
    }

    private int getPositiveOperand(String operand) {
        int intOperand = Integer.parseInt(operand);
        if(intOperand < 0) {
            throw new RuntimeException("미지원 타입");
        }

        return intOperand;
    }

    private int getOperandsLength() {
        return this.operands.length;
    }
}

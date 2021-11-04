package study02;

public class Formula {

    private final String[] splitFormula;

    public Formula(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException("수식 문자열이 Null 입니다.");
        }
        if (formula.trim().length() == 0) {
            throw new IllegalArgumentException("수식 문자열은 비어있을 수 없습니다");
        }
        this.splitFormula = formula.split(" ");
    }

    public String[] getSplitFormula() {
        return splitFormula;
    }
}

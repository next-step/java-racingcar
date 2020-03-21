package study;

public class FormulaCalculator {

    private static final String DEFAULT_TOKEN = " ";

    private String formula;
    private String[] items;

    /*
        constructor
     */
    public FormulaCalculator(String formula) {
        this(formula, DEFAULT_TOKEN);
    }

    public FormulaCalculator(String formula, String token) {
        this.formula = formula;
        validateEmpty();
        this.items = formula.split(token);
        validateFormula();
    }

    /*
        validation check
     */
    private void validateEmpty() {
        // null, empty
        if ( formula == null || formula.isEmpty() || formula.trim().isEmpty() ) {
            throw new IllegalArgumentException(UnitFormula.MSG_EMPTY_FORMULA);
        }
    }
    private void validateFormula() {
        // split 된 결과는 항상 홀수여야 정상적인 수식
        if ( items.length == 0 || items.length %2 != 1 ) {
            throw new IllegalArgumentException(UnitFormula.MSG_INVALID_FORMULA);
        }
    }

    /*
        functional
     */
    public float getResult() {

        float result = new UnitFormula(items[0]).getResult();

        if ( items.length < 2 ) {
            return result;
        }

        // 생성자에서 필터되어 홀수개일때만 동작
        for (int i = 1; i < items.length; i = i + 2) {
            UnitFormula unit = new UnitFormula(result, items[i], items[i+1]);
            result = unit.getResult();
        }
        return result;
    }
}

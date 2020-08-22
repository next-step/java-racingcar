package step2;

class Formula {

    private String[] formula;

    Formula(String formula){
        this.formula = formula.split(Constant.FORMULA_SPLITTER);
    }

    String[] getFormula(){
        return formula;
    }

}

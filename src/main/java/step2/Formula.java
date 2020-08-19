package step2;

class Formula {

    private String[] formula;

    Formula(String formula){
        this.formula = formula.split(" ");
    }

    String[] getFormula(){
        return formula;
    }

}

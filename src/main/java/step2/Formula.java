package step2;

class Formula {

    private String formula;

    Formula(String formula){
        this.formula = formula;
    }

    String[] splitFormula(){
        return formula.split(" ");
    }

}

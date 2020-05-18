package chactercalculator;

public class StringTrimmer {

  public static String[] separateValuesFromFormula(String formula) {
    final String SEPARATOR = " ";
    return formula.split(SEPARATOR);
  }
}

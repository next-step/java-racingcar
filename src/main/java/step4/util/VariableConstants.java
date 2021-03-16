package step4.util;

public enum VariableConstants {
  VARIABLE_NAME_SPLIT(","),
  RESULT_VIEW_LINE("\n"),
  RESULT_VIEW_SCORE_FIELD("-"),
  RESULT_VIEW_DELIMITTER(" : ")
  ;

  private final String value;

  VariableConstants(String value){
    this.value = value;
  }

  public String getValue(){
    return value;
  }
}

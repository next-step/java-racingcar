package step1;

public class StringStudy {

  /**
   * 문자(param)를 구분자(delimiter)로 split한다.
   * 
   * @param param     : String, 나눌 문자
   * @param delimiter : String, 구분자
   * @return String[], 구분자로 나뉘어진 문자를 배열로 반환한다.
   */
  public String[] split(String param, String delimiter) {
    return param.split(delimiter);
  }

}
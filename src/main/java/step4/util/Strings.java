package step4.util;

import java.util.Arrays;

public class Strings {
  private Strings() {}

  public static boolean checkNotNullOrNotEmpty(String str){
    return str!=null && !str.trim().isEmpty();
  }

  public static boolean checkFactorsNotEmpty(String str, String splitter){
    if(!checkNotNullOrNotEmpty(str)) return false;
    long inValidCount = Arrays.stream(str.split(splitter)).filter(name -> name.trim().isEmpty()).count();
    return inValidCount==0;
  }

  public static boolean checkFactorsMaximumLength(String str, String splitter, int maxLength){
    long inValidCount = Arrays.stream(str.split(splitter)).filter(name -> name.length()>maxLength).count();
    return inValidCount==0;
  }
}

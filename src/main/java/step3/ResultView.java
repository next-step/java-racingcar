package step3;

public class ResultView {

  public static void print (int[] position) {
    String result = "";
    for (int n : position) {
      for (int i = 0; i < n; i++)
        result += "-";
      result += "\n";
    }
    System.out.println(result);
  }

}

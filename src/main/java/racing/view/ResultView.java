package racing.view;

public class ResultView {
  private static final String PROGRESS_BAR = "-";

  public static void end(){
    System.out.println("===============레이스가 종료되었습니다.===============");
  }

  public static void start(){
    System.out.println("===============레이스 시작!!!===============");
  }

  public static void round(int i){
    System.out.println(String.format("===============ROUND [%s]===============", i));
  }

  public static void raceProgress(int count){
    for (int i=0; i<count; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

}

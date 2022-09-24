package RacingCar;

public class ResultView {
    public static void resultView(){
        System.out.println("실행 결과");
    }

    public static void positionView(int position){
        for(int i = 0 ; i < position ; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}

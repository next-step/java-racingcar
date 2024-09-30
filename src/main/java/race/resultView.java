package race;

public class resultView {
    public static final String EXECUTION = "\n실행 결과";

    public static void printResultView(){
        System.out.println(EXECUTION);
    }
    public static void printLocationResultView(int state) {
        for(int i=0 ; i<state; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

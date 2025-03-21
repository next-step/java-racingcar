import java.util.List;

public class ResultView {

    public void print(List<List<Integer>> result) {
        System.out.println();
        System.out.println("실행 결과");

        for (List<Integer> cars : result) {
            for(int car : cars){
                printDash(car);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printDash(int count) {
        while(count-->0){
            System.out.print("-");
        }
        System.out.println();
    }
}

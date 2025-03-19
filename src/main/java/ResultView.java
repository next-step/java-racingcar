public class ResultView {
    private final StringBuilder builder = new StringBuilder();

    public void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printDash(int count) {
        while(count-->0){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printFinish() {
        System.out.println();
    }
}

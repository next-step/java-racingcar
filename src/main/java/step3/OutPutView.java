package step3;

public class OutPutView {
    public void print(int distance){
        for (int i = 0 ; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printGap() {
        System.out.println();
    }
}

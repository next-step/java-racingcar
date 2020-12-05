package racing;

public class Display {
    private static final char sign = '-';
    public void printLine(String context) {
        System.out.println(context);
    }

    public void printMove() {
        System.out.print( this.sign);
    }
    public void printEmptyLine(){
        System.out.println();
    }
}

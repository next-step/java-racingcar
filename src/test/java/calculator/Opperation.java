package calculator;

public class Opperation{
    Arithmetic add = (x,y) -> x+y;
    Arithmetic minus = (x,y) -> x-y;
    Arithmetic multipy = (x,y) -> x*y;
    Arithmetic divide = (x,y) -> x/y;

    public void test(){
        add.Calc(1,2);
    }
}

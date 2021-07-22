package Calculater;

public class Division extends Calculator {
    @Override
    public int resultCalculater(int divisor, int dividend) {
        if(dividend == 0){
         throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
        return divisor/ dividend;
    }
}

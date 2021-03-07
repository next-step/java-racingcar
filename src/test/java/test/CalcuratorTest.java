package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcuratorTest {
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    String expression = "";
    @BeforeEach
    void setUp() {
        a = 10;
        b = 15;
        c = 20;
        d = 40;
        expression = "3 + 4";
    }

    //더하기
    private int _sum(int a , int b){
        return a+b;
    }
    //뺄셈
    private int _minus(int a , int b){
        return a-b;
    }
    //곱셈
    private int _multiply(int a , int b){
        return a*b;
    }
    //나눗셈
    private int _divide(int a , int b){
        return (int)(a/b);
    }

    @Test
    @DisplayName("더하기 Test")
    public void sum(){
        assertThat(a+b).isEqualTo(25);
    }

    @Test
    @DisplayName("뺄셈 Test")
    void minus() {
        assertThat(a-b).isEqualTo(-5);
    }

    @Test
    @DisplayName("곱셈 Test")
    void multiply() {
        assertThat(a*b).isEqualTo(150);
    }

    @Test
    @DisplayName("나눗셈 Test")
    void divide() {
        assertThat(a/b).isEqualTo(0);
    }

    @Test
    @DisplayName("빈칸있을때까지 숫자 변환 Test")
    void changeNum(){
        String str = "123 ";
        String testStr = "";
        for(int i=0;i<str.length();i++){
            if(' ' ==(str.charAt(i))){
                break;
            }
            testStr += str.charAt(i);
        }
        assertThat(Integer.parseInt(testStr)).isEqualTo(123);
    }


    @Test
    void executeTest(){
        String numStr = "";
        String numStr2 = "";
        int num =0;
        int num2 = 0;
        ArrayList<String> saveExp = new ArrayList<>();
        String sign = null;

        int result = 0;
        for(int i=0;i<expression.length(); i++){
            char ch = expression.charAt(i);

            if('0'<= ch && ch <= '9'){
                numStr += ch;
            }else if(ch == ' '){
                saveExp.add(numStr);
                if("+".equals(sign)){
                    result += _sum(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                    saveExp.clear();
                }else if("-".equals(sign)){
                    result += _minus(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                    saveExp.clear();
                }else if("*".equals(sign)){
                    result += _multiply(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                    saveExp.clear();
                }else if("/".equals(sign)){
                    result += _divide(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                    saveExp.clear();
                }

                numStr = "";
            }else if(ch=='+' || ch=='-' || ch=='*' || ch =='/'){
                sign = String.valueOf(ch);
            }
        }
            assertThat(result).isEqualTo(7);
        }

}

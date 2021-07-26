package step2.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }
    private void run(){
        /*
        계산을 진행
        오류가 발생했을 때 에러 메세지를 돌려준다.
         */
        while (true){
            String cmd = requestInput();
            if (cmd.equals("q")){
                break;
            }
            try{
                validInput(cmd);
                Calculator cal = new Calculator(cmd);
                cal.calc();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    private String requestInput(){
        /*
        값을 입력 받고, 전달 받은 값을 돌려준다.
         */
        System.out.println("===============================");
        System.out.println("계산할 값을 입력하세요");
        System.out.println("계산을 종료하고 싶다면 q를 입력해주세요");
        System.out.println("===============================");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void validInput(String cmd){
        String[] operatorAry = {"+","-","*","/"};
        String[] cmdAry = cmd.split(" ");

        if (cmdAry.length <= 1 || cmdAry.length % 2 == 0) {
            throw new IllegalArgumentException("값을 제대로 입력 하셨나요?");
        }

        for (int i = 0; i < cmdAry.length; i+=2) {
            if (!cmdAry[i].matches("^[0-9]*$")) {
                // 입력 값이 숫자가 아닐 경우
                throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
            }
        }
        for (int i = 1; i < cmdAry.length; i+=2) {
            if (!Arrays.asList(operatorAry).contains(cmdAry[i])) {
                // 사칙연산 기호가 아닌 경우
                throw new IllegalArgumentException("사칙 연산 기호가 존재하지 않습니다.");
            }
        }
    }
}

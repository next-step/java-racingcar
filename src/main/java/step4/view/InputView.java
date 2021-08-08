package step4.view;

import step4.model.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    /**
     * 빈값일 경우를 검사한다.
     * @param input
     * @return
     */
    public boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * 입력값을 쉼표로 분리해서 이름각각 빈값인 경우를 검사한다.
     * @param input
     * @return
     */
    public boolean isBlankName(String input) {
        //이름 각각에 대한 빈값 검사
        String[] names = splitName(input);
        if(names.length == 0) return true;

        for (String name : names) {
            if (name == null || name.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * 입력값을 쉼표로 분리한다.
     * @param input
     * @return
     */
    public String[] splitName(String input) {
        return input.split(",");
    }

    /**
     * 입력값을 입력받는다.
     * @param category
     * @return
     */
    public String getInput(Message category) {
        Scanner sc = new Scanner(System.in);
        System.out.println(category.getInputMessage());
        String input = sc.nextLine();
        return input;
    }

    /**
     * 입력값이 숫자인지 아닌지 판단한다.
     * @param input
     * @return
     */
    public boolean isDigit(String input) {
        return input.matches("[0-9]*");
    }

    /**
     * 자동차 이름을 입력받아 빈값, 길이 예외를 처리한다.
     * @param category
     * @return
     */
    public List<String> askName(Message category){
        //입력받기
        String input = getInput(category);

        //빈값 예외처리
        if (isBlank(input) || isBlankName(input)) {
            throw new IllegalArgumentException(category.getErrorMessage());
        }

        return Arrays.asList(splitName(input));
    }


    /**
     * 시도횟수를 입력받는다.
     * @param category
     * @return
     */
    public int askTryCnt(Message category) {
        //입력받기
        String input = getInput(category);

        //빈값일 경우, 숫자가 아닐경우, 0이하일 경우 예외처리
        if (isBlank(input) || !isDigit(input) || !isOverZero(input)) {
            throw new IllegalArgumentException(category.getErrorMessage());
        }

        return Integer.parseInt(input);
    }

    /**
     * 0 이하의 숫자를 입력을 검사한다.
     * @param input
     * @return
     */
    private boolean isOverZero(String input) {
        int cnt = Integer.parseInt(input);

        if (cnt <= 0) {
            return false;
        }

       return true;
    }


}

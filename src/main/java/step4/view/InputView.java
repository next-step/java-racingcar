package step4.view;

import step4.model.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int MAX_CAR_LENGTH = 5;

    public boolean isOverLength(String input) {
        String[] names = splitName(input);

        for(String name : names){
            if (name.length() > MAX_CAR_LENGTH) {
                return true;
            }
        }

        return false;
    }

    public boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public String[] splitName(String input) {
        return input.split(",");
    }

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

    public List<String> askName(Message category){
        //입력받기
        String input = getInput(category);

        //빈값 예외처리
        while (isBlank(input)) {
            System.out.println(category.getErrorMessage());
            input = getInput(category);
        }

        //길이 예외처리
        while (isOverLength(input)) {
            System.out.println("자동차 이름은 5자 이상 입력할 수 없습니다.");
            input = getInput(category);
        }

        System.out.println(category.getConfirmMessage());

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
        while (isBlank(input) || !isDigit(input) || !isOverZero(input)) {
            System.out.println(category.getErrorMessage());
            input = getInput(category);
        }

        System.out.println(category.getConfirmMessage());

        return Integer.parseInt(input);
    }

    private boolean isOverZero(String input) {
        int cnt = Integer.parseInt(input);

        if (cnt <= 0) {
            return false;
        }

       return true;
    }


}

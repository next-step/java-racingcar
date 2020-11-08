package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

import racingcar.util.ErrorMessage;

public class InputView {
    public static final String NUM_OF_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String LOOP_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_INPUT_VALUE = 0;
    private static final String COMMA = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputNameOfCars() {
        return getNameOfCars(NUM_OF_NAME_MESSAGE);
    }

    public static String[] getNameOfCars(String content) {
        System.out.println(content);
        String inputName = SCANNER.next();
        //        int numOfNames = names.length;
//        validateInputNum(numOfNames);
        return splitValues(inputName);
    }

    static String[] splitValues(String inputName) {
        return Arrays.stream(inputName.split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }


//    static void validInputName(String [] carNames) {
//        Arrays.stream(carNames)
//                .filter()
//                .forEach(s -> isValidInputName(s))
//
//                //.orElseThrow(s -> new IllegalArgumentException(ErrorMessage.INPUT_NAME_ERROR));
//
////       for(String carName : carNames){
////           if (isValidInputName(carName)) {
////               throw new IllegalArgumentException(ErrorMessage.INPUT_NAME_ERROR);
////           }
////       }
//    }

//    static boolean isValidInputName(String inputName) {
//        return isNullOrEmpty(inputName) || isFiveLetterWords(inputName);
//    }
//
//    static boolean isNullOrEmpty(String name) {
//        return name.isEmpty() || name.equals(BLANK);
//    }
//
//    static boolean isFiveLetterWords(String name) {
//        return name.length() > MAX_INPUT_NAME_VALUE;
//    }

    public static int inputLoopCount() {
        System.out.println(LOOP_COUNT_MESSAGE);
        int value = SCANNER.nextInt();
        validateInputNum(value);
        return value;
    }

    static void validateInputNum(int inputNumber) {
        if (isValidInputNumber(inputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }

    static boolean isValidInputNumber(int inputNumber) {
        return inputNumber <= MIN_INPUT_VALUE;
    }
}
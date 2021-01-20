package racingcar;

public class Validator {
    public static void checkEmptyInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이거나 빈 데이터가 있습니다. 다시 입력해 주세요.");
        }
    }

    public static void checkEmptyElement(String input) throws IllegalArgumentException {
        for(String element : input.split(",")){
            checkEmptyInput(element);
        }
    }

    public static void checkLastValueComma(String input) throws IllegalArgumentException {
        if (input.charAt(input.length()-1) == ','){
            throw new IllegalArgumentException("마지막 값이 제대로 입력되지 않았습니다. 다시 입력해 주세요.");
        }
    }

    public static void checkNumber(String input) throws IllegalArgumentException{
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다. 다시 입력해주세요.");
        }
    }

    public static void checkCarNameLength(String input) throws IllegalArgumentException{
        String[] carsNames = input.split(",");
        for(String carName : carsNames) {
            checkGreaterThan5(carName);
        }
    }

    private static void checkGreaterThan5(String carName) throws IllegalArgumentException{
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}

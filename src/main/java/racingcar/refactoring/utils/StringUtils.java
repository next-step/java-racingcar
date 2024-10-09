package racingcar.refactoring.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static String[] split(String input) {
        String[] values = input.split(",");
        return values;
    }

    public static String repeatCharacter(Character character, int count) {
        return character.toString().repeat(count);
    }
}

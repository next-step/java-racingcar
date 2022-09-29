package step4;

public class Validation {
    private static final int NAME_LENGTH = 5;
    public static void checkName(String name) {
        if(name.length() > NAME_LENGTH) {
            throw new RuntimeException();
        }
    }
}

package step3.exception;

public class WrongGameSettingException extends IllegalArgumentException {

    public WrongGameSettingException(String s) {
        super(s);
    }
}

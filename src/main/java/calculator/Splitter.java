package calculator;

public class Splitter {

    private String string;

    private Splitter(String string) {
        this.string = string;
    }

    public static Splitter of(String string) {
        return new Splitter(string);
    }


    public String[] splitByString() {
        return this.string.split("\\s");
    }

}

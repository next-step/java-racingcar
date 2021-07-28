package step5.view;

public class InputData {
    private String[] names;
    private int times;

    private InputData(String[] names, int times) {
        this.names = names;
        this.times = times;
    }

    public static InputData of(String[] names, int times){
        return new InputData(names, times);
    }

    public String[] getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}

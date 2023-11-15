package study.racingCar;

public class StringToIntConverter {
    public StringToIntConverter() {
    }

    public int converter(String str){
        int num = Integer.parseInt(str);
        if (num < 0){
            throw new IllegalArgumentException();
        }
        return num;
    }
}

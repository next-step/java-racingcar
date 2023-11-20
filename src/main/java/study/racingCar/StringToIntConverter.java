package study.racingCar;

public class StringToIntConverter {
    public StringToIntConverter() {
    }

    public int converter(String str){
        int num = Integer.parseInt(str);
        if (num < 1){
            System.out.println("양수가 아닌 값을 입력했습니다.");
            throw new IllegalArgumentException();
        }
        return num;
    }
}

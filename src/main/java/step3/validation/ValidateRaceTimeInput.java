package step3.validation;

public class ValidateRaceTimeInput {

    public static int range(int times) {
        if (times < 0 || times > 9) {
            throw new IllegalArgumentException("전진하는 조건은 0 ~ 9 사이 입니다.");
        }

        return times;
    }
}

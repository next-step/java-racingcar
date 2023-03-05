package racingcar;

public class racingcar {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }



    static public String[] seperateMember(String StringCarMember) {
        return StringCarMember.split(",");
    }

    static boolean validateCarlength(String StringCarMember) {
        String [] ArrayCarMember = seperateMember(StringCarMember);

        for(int i = 0; i < ArrayCarMember.length -1; i += 1) {
            if(ArrayCarMember[i].length() > 5) continue;
                return false;
        }
        return true;
    }

}



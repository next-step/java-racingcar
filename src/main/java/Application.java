import calculator.Calculator;
import calculator.ElementGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing.CarGenerator;
import racing.Judgement;
import racing.Racing;

public class Application {

    public static void main(String[] args) throws IOException {
//        calculateString();
        carRacing();
    }

    private static void carRacing() throws IOException {
        //TODO: Step2에서 입출력 분리 리팩토링 예정
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames = br.readLine();

        System.out.println("최종우승자: " + String.join(", ",
                new Judgement(
                    new Racing(
                        CarGenerator.createCars(carNames)
                    ).race()
                ).judgeWinner()
            )
        );
    }

    private static void calculateString() throws IOException {
        //TODO: Step2에서 입출력 분리 리팩토링 예정
        System.out.println("문자열을 공백으로 구분하여 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        ElementGenerator elementGenerator = new ElementGenerator(expression);

        System.out.println(
            new Calculator(
                elementGenerator.getNumbers(), elementGenerator.getOperators()
            ).execute()
        );
    }
}

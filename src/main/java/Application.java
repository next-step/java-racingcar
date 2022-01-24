import calculator.Calculator;
import calculator.ElementGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racing.Car;
import racing.CarGenerator;
import racing.Judgement;
import racing.Racing;

public class Application {

    public static void main(String[] args) throws IOException {
//        calculateString();
        carRacing();
    }

    private static void carRacing() throws IOException {
        //TODO: Step2에서 리팩토링 예정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = br.readLine();

        //차 생성
        CarGenerator carGenerator = new CarGenerator();
        List<Car> cars = carGenerator.createCars(carNames, 5, 4);

        //레이스 실행
        Racing racing = new Racing(cars);
        racing.race();

        //결과 판단
        Judgement judgement = new Judgement(cars);
        List<String> winners = judgement.judgeWinner();

        //출력
        System.out.println("최종우승자: " + String.join(", ", winners));
    }

    public static void calculateString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ElementGenerator elementGenerator = new ElementGenerator(br.readLine());
        String[] elements = elementGenerator.getElements();

        Calculator calculator = new Calculator();
        double result = calculator.execute(elements);

        System.out.println(result);
    }
}

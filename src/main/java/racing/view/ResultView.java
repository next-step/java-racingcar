package racing.view;


public class ResultView implements View {

    String result;

    @Override
    public void render() {
        System.out.println("실행 결과");
        System.out.print(result);
    }

    public void setResult(String result) {
        this.result = result;
    }
}

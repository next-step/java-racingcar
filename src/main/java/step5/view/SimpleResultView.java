package step5.view;

public class SimpleResultView implements ResultView {

    private final String token;

    public SimpleResultView(String token) {
        this.token = token;
    }

    @Override
    public String makeResult(String name, int position) {
        return name + " : " + String.valueOf(token).repeat(position);
    }
}

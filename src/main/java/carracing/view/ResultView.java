package carracing.view;

public class ResultView {
    private static final String MOVE_MARK = "-";
    private String result = "";

    public String getResult() {
        return result;
    }

    public void print(Integer step) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < step; i++) {
            this.result = builder.append(MOVE_MARK).toString();
        }
        System.out.println(getResult());
    }
}

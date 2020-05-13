package CarRacing;

public class ScannerView extends View {
    @Override
    public void view() {
        System.out.println("Scanner View");
    }

    @Override
    public void initView() {
        System.out.println("Scanner View Init");
    }

    @Override
    public void endView() {
        System.out.println("Scanner View End");
    }
    
    public void textView(String text) {
        System.out.println(text);
    }
}

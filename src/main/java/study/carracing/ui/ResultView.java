package study.carracing.ui;

import java.util.List;

public interface ResultView {

    void outputTitle();

    <Type> void outputResult(List<Type> items);

    <Type> void outputResultAndComment(List<Type> items);
}

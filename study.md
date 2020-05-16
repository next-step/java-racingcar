# document for TODO, memo, feedback or references ..

### assertJ 학습 가이드
- https://assertj.github.io/doc/
- https://www.baeldung.com/introduction-to-assertj

### 자바 코딩 컨벤션
- https://google.github.io/styleguide/javaguide.html


### 메소드 참조와 익명클래스 및 람다

- 정적 메소드를 통한 메소드 참조 vs 익명 클래스 vs 람다의 비교 .. 끄적..
   
   + 익명 클래스는 함수의 길이가 너무 길다. 그러므로 함수형 프로그래밍에 적합하지 않다. 결국 코드가 간결하지 않다.
   
   + 익명 클래스는 람다를 사용하지 못할 경우에 사용할 수 있다는 장점만 가진다.
        
   + 람다는 이를 보안하며, 어떤 동작인지에 대해 명확하다. 반대로 명확하지 않거나 코드가 많아지면 람다를 사용해서는 안된다. 혼란만 가중화 될 뿐이다.
   
   + 메소드 레퍼런스는 람다보다 더 간결하다는 장점을 갖는다.
   
   + 무조건 정적 메소드를 참조하라는 것은 아니다. 메소드 참조 쪽이 짧고 명확하면 메소드 참조를 쓰고, 그렇지 않고 람다로 표현되면 람다로 쓰는게 좋다.
   
- 결론: Operator enum Class의 DoubleBinaryOperator는의 연산 메소드들은 람다로도 충분히 표현 가능하므로, 람다가 나을 것 같다.
     


### feedback

- String matches 보단 Pattern.compile을 사용할 것
    + https://velog.io/@edwin/JAVA-%EC%A0%95%EA%B7%9C%EC%8B%9D-%EC%84%B1%EB%8A%A5%EC%97%90-%EB%8C%80%ED%95%B4-Pattern.matcher-VS-String.matches
    + https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

- 인스턴스화 되지 않을 클래스는 생성자 생성을 막을 것
    + https://madplay.github.io/post/enforce-noninstantiability-with-private-constructor

- Util 클래스에 대한 고려
    + https://www.mimul.com/blog/oop-alternative-to-utility-classes/
    
- 정적 팩토리 메소드 https://johngrib.github.io/wiki/static-factory-method-pattern/

    + 흔히 사용되는 이름들
        - valueOf
        - of
        - getInstance
        - newInstance
        - getType
        - newType ..

    + 정적 팩토리 메소드는 다른 정적 메소드와 분리하기 어려울 수 있다.
    
- test -> feat -> 이후 리팩토링 단계에서 예외 케이스를 한 번 더 생각 해볼 것, 최종 단계에서 한 번 더 생각해볼 것

- 테스트 중 객체 요소에 대한 검증보단, 객체간의 비교에 중점을 둘 것
    + 객체의 모든 개별요소를 한번에 확인할 수 있다
    + 객체의 동등성 검증도 할 수 있다
    + 그리고 불필요한 getter 메소드를 없앨 수 있다

## 조언주신 규칙 적용할것들
- [규칙 1: 메서드당 들여쓰기 한번](https://developerfarm.wordpress.com/2012/01/26/object_calisthenics_2/)

- 랜덤 메서드를 매번 뽑는것 보다 인스턴스를 만들어서 nextInt를 사용하자
```java
    public static int generateRandomNumber() {
        return new Random().nextInt(BOUND_CONDITION);
    }
```




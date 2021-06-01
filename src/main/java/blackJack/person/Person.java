package blackJack.person;

public abstract class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    abstract String getName();

}

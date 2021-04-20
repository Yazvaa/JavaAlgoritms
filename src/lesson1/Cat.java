package lesson1;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void printData(){
        System.out.println("Моё имя - "+ this.name+", мне - "+this.age+" лет");
    }
}

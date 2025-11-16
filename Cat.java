public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String toString() {
        return "кот: " + name;
    }

    public void meow() {
        System.out.println(name + ": мяу");
    }
}

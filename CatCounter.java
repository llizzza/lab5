public class CatCounter implements Meowing{

    private Cat cat;
    private int count = 0;

    public CatCounter(Cat cat) {
        this.cat = cat;
    }

    public void meow() {
        count++;
        cat.meow();
    }

    public int getCount() {
        return count;
    }
}

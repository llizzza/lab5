public class Participant {
    private String surname;
    private String name;
    private int score1;
    private int score2;
    private int score3;

    public Participant(String surname, String name, int score1, int score2, int score3) {
        this.surname = surname;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public int getTotalScore() {
        return score1 + score2 + score3;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return surname + " " + name + " — сумма баллов: " + getTotalScore();
    }
}

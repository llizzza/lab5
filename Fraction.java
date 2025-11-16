public class Fraction implements FractionInterface {
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не можеть быть равен нулю!");
        }
        if (denominator < 0) {
            this.denominator = -denominator;
            this.numerator = -this.numerator;
        } else {
            this.denominator = denominator;
        }
    }

    public double toDouble() {
        return (double) numerator/denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction other)) {
            return false;
        }
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
}

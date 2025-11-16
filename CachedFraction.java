public class CachedFraction extends Fraction {
    private Double cached = null;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cached = null;
    }

    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cached = null;
    }

    public double toDouble() {
        if (cached == null) {
            cached = super.toDouble();
        }
        return cached;
    }
}

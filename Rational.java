public class Rational {

    double numerator;
    double denominator;

    public Rational(double numerator, double denominator) {

        // Check if the numerator is an integer.
        if (numerator != (int) numerator) {
            throw new IllegalArgumentException("Not valid p");
        }

        // Check if the denominator is an integer and is greater than zero.
        if (denominator != (int) denominator || denominator <= 0) {
            throw new IllegalArgumentException("Not valid q");
        }

        // Set the instance variables.
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public boolean greaterThan(Rational r) {

        // Throw an exception if the other rational number is null.
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");

        return this.numerator * r.denominator > r.numerator * this.denominator;
    }

    @Override
    // Compare two rational numbers by cross multiplication to ensure precision.
    public boolean equals(Object r) {
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");
        if (this == r) return true;

        // Ensure the object is a Rational instance.
        if (r instanceof Rational) {
            Rational temp = (Rational) r;
            return this.numerator * temp.denominator == temp.numerator * this.denominator;

        }
        return false;
    }

    // Add two rational numbers by finding a common denominator.
    public Rational plus(Rational r) {
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");
        return new Rational((this.numerator * r.denominator) + (r.numerator * this.denominator), this.denominator * r.denominator);
    }

    // Subtract two rational numbers by finding a common denominator.
    public Rational minus(Rational r) {
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");
        return new Rational((this.numerator * r.denominator) - (r.numerator * this.denominator), this.denominator * r.denominator);
    }


    // Multiply two rational numbers by multiplying their numerators and denominators.
    public Rational multiply(Rational r) {
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");
        return new Rational(this.numerator * r.numerator, this.denominator * r.denominator);
    }

    public Rational divide(Rational r) {
        if (r == null) throw new IllegalArgumentException("Operand cannot be null.");

        // Check for division by zero scenario.
        if (r.numerator * r.denominator == 0) {
            throw new ArithmeticException("Deviation by zero is forbidden");
        }
        return new Rational(this.numerator * r.denominator, this.denominator * r.numerator);
    }

    public double getNumerator() {
        return this.numerator;
    }

    public double getDenominator() {
        return this.denominator;
    }

    @Override
    // Provide a string representation of the rational number in the form "numerator/denominator".
    public String toString() {
        return String.format("%d/%d", (int) this.numerator, (int) this.denominator);
    }


    // Reduce the fraction to its simplest form by finding the greatest common divisor (GCD).
    public Rational reduce() {
        double a = this.numerator;
        double b = this.denominator;
        double temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return new Rational(this.numerator / a, this.denominator / a);
    }


}


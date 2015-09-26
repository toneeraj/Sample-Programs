package com.programming;

import java.math.BigInteger;

public class Suite2Basic {

	// Represents a function in ternms of numerator and denominator
	static class Fraction {
		private BigInteger numerator;
		private BigInteger denominator;

		public BigInteger getNumerator() {
			return this.numerator;
		}

		public void setNumerator(BigInteger numerator) {
			this.numerator = numerator;
		}
		
		public BigInteger getDenominator() {
			return this.denominator;
		}
		
		public void setDenominator (BigInteger denominator) {
			this.denominator = denominator;
		}

		Fraction() {
			this.numerator = new BigInteger("0");
			this.denominator = new BigInteger("1");
		}

		Fraction(BigInteger numerator, BigInteger denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		// let us sum the elements of this chessboard using (a/b) + (c/d) = (a*d
		// + b*c) / (b*d)
		public Fraction sum(Fraction secondFraction) {
			BigInteger numerator = (this.numerator.multiply(secondFraction.denominator)).add((this.denominator.multiply(secondFraction.numerator)));
			BigInteger denominator = this.denominator.multiply(secondFraction.denominator);
			BigInteger gcd = numerator.gcd(denominator);
			numerator = numerator.divide(gcd);
			denominator = denominator.divide(gcd);
			return new Fraction(numerator, denominator);
		}

	}

	public static String game(long n) {
		// your code

		if (n == 0) {
			return "[0]";
		}

		if (n == 1) {
			return "[1, 2]";
		}

		BigInteger baseNumerator = BigInteger.ONE;
		BigInteger baseDenominator = new BigInteger("2");
		BigInteger numerator = baseNumerator;
		BigInteger denominator = baseDenominator;
		Fraction winnerSum = new Fraction();
		
		for (long row = 0; row<n; row++) {
			Fraction rowFractionSum = new Fraction();

			for (long column = 0; column < n; column++) {
			
				Fraction rowFraction = new Fraction(numerator, denominator);
				rowFractionSum = rowFractionSum.sum(rowFraction);
				
				numerator = numerator.add(BigInteger.ONE);
				denominator = denominator.add(BigInteger.ONE);
			}
			
			winnerSum = winnerSum.sum (rowFractionSum);
			
			numerator = baseNumerator;
			baseDenominator = baseDenominator.add(BigInteger.ONE);
			denominator = baseDenominator;
		}

		// Print the sum as expected by the program

		if (winnerSum.getDenominator().intValue() == 1) {
			return new String("[" + winnerSum.getNumerator() + "]");
		} else {
			return new String("[" + winnerSum.getNumerator().toString()
					+ ", " + winnerSum.getDenominator().toString() + "]");
		}
	}
}

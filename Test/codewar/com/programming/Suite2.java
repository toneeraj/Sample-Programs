package com.programming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.programming.Suite2Basic.Fraction;

public class Suite2 {
	
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
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.println(cpus);
		
		// would keep this of other tasks as well.
		ExecutorService service = Executors.newFixedThreadPool(cpus);
		
		List<Future<Fraction>> tasks = new ArrayList<>();
		
		int blockSize = (int) (n + cpus - 1) / cpus;
		
		
		BigInteger baseNumerator = BigInteger.ONE;
		BigInteger baseDenominator = new BigInteger("2");
		final BigInteger numerator = baseNumerator;
		final BigInteger denominator = baseDenominator;
		Fraction winnerSum = new Fraction();
		
		for (int i=0; i <  n; i++) {
		    final long start = blockSize * i;
		    final long end = Math.min(blockSize * (i+1), n);
			final Fraction rowFractionSum = new Fraction();
		    tasks.add(service.submit(new Callable<Fraction>() {
		        public Fraction call() {
		        	Fraction rowFraction = new Fraction(numerator, denominator);
					rowFractionSum = rowFractionSum.sum(rowFraction);
					
					numerator = numerator.add(BigInteger.ONE);
					denominator = denominator.add(BigInteger.ONE);
					
					return rowFractionSum;	
		        }
		     }));
		}
		
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}

// author : Fred Migeon - IRIT - Université Toulouse 3
package d_functionalExpression;

public class SequentialAndFunctional {

	private static final int NB_CALL_FOR_STAT = 1000;

	public long g(int count) {
		int res = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				for (int k = 0; k < count; k++) {
					res++;
				}
			}
		}
		return res;
	}

	public long sequential(int val) {
		long res1 = g(val);
		long res2 = g(2 * val);

		return res1 + res2;
	}

	public long functional(int val) {
		return g(val) + g(2 * val);
	}

	public static void main(String[] args) {
		SequentialAndFunctional test = new SequentialAndFunctional();

		long startTime = System.currentTimeMillis();
		for (int callNb = 0; callNb < NB_CALL_FOR_STAT; callNb++) {
			test.g(1000);
		}
		long endTime = System.currentTimeMillis();
		double elapsedTime = (endTime - startTime);
		System.out.println("Execution time for g : " + elapsedTime);

		startTime = System.currentTimeMillis();
		for (int callNb = 0; callNb < NB_CALL_FOR_STAT; callNb++) {
			test.sequential(1000);
		}
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for sequential : " + elapsedTime);

		startTime = System.currentTimeMillis();
		for (int callNb = 0; callNb < NB_CALL_FOR_STAT; callNb++) {
			test.functional(1000);
		}
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for functional : " + elapsedTime);

	}

}

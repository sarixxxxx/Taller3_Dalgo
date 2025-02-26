package uniandes.algorithms.coinchange;

import java.util.Arrays;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int n=denominations.length;
		int[] resultado=new int[n];
		Arrays.fill(resultado, 0);
		
		int[] mejorSolucion=new int[n];
		Arrays.fill(mejorSolucion,Integer.MAX_VALUE);
		
		funcionRecursiva(0,1,totalValue, denominations, resultado, mejorSolucion);
		return mejorSolucion;
	}

	private void funcionRecursiva(int i, int m, int P, int[] D, int[] solActual,
			int[] mejorSolucion) {
		if(i>=D.length) {
			return;
		}
		if(D[i]*m==P) {
			solActual[i]=m;
			
			if(cantidadMonedas(solActual)<cantidadMonedas(mejorSolucion)) {
				System.out.println("Habemus cosas");
				System.arraycopy(solActual, 0, mejorSolucion, 0, D.length);
				Arrays.fill(solActual, 0);
			}
			return;
		}
		if(D[i]*m>P) {
			//solActual[i]=0;
			return;
		}
		funcionRecursiva(i+1, 1,P, D, solActual, mejorSolucion);
		solActual[i]=m;
		funcionRecursiva(i, m+1, P-D[i]*m, D, solActual, mejorSolucion);	
		funcionRecursiva(i+1, 1,P-D[i]*m, D, solActual, mejorSolucion);
		solActual[i]=m-1;
		
	}

	private int cantidadMonedas(int[] solActual) {
		// TODO Auto-generated method stub
		int sum = 0;
        for (int count : solActual) {
            if (count != Integer.MAX_VALUE) sum+=Integer.MAX_VALUE;
            sum += count;
        }
        return sum;
	}

}

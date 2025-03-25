package uniandes.algorithms.coinchange;

import java.util.Arrays;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int n=denominations.length;
		int[] solActual=new int[n];
		Arrays.fill(solActual, 0);
		
		
		int[] mejorSolucion=funcionRecursiva(0,1,totalValue, denominations, solActual);
		return mejorSolucion;
	}

	private int[] funcionRecursiva(int i, int m, int P, int[] D, int[] solActual) {
		if(i>=D.length) {
			int[] lista=new int[D.length];
			Arrays.fill(lista, Integer.MAX_VALUE);
			return lista;
		}
		if(D[i]*m==P) {
			solActual[i]=m;
			return solActual;
		}
		if(D[i]*m>P) {
			int[] lista=new int[D.length];
			Arrays.fill(lista, Integer.MAX_VALUE);
			return lista;
		}
		int [] m1=funcionRecursiva(i+1,1,P, D, solActual.clone());
		int [] m2=funcionRecursiva(i+1, 1, P-D[i]*m, D, solActual.clone());	
		m2[i]+=m;
		int [] m3=funcionRecursiva(i, m+1,P, D, solActual.clone());
		if ( cantidadMonedas(m1)<=cantidadMonedas(m2) && cantidadMonedas(m1)<=cantidadMonedas(m3)) {
			return m1;
		}else if(cantidadMonedas(m2)<=cantidadMonedas(m3) && cantidadMonedas(m2)<=cantidadMonedas(m1)){
			return m2;
		}else {
			return m3;
		}
		
	}

	private int cantidadMonedas(int[] solActual) {
		// TODO Auto-generated method stub
		int sum = 0;
        for (int count : solActual) {
            if (count == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            sum += count;
        }
        return sum;
	}

}

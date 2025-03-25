package uniandes.algorithms.coinchange;

import java.util.Arrays;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		
		int[] resultado= new int[denominations.length];
		Arrays.sort(denominations);
		int m=0;
		for (int i=(denominations.length-1 ); i>=0; i--) {
			m=totalValue/denominations[i];
			if(m>0) {
				resultado[i]=m;
				totalValue%=denominations[i];
			}
		}
		return resultado;
	}
	
}

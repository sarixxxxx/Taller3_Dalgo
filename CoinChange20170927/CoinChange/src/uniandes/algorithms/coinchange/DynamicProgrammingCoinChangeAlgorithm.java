package uniandes.algorithms.coinchange;

public class DynamicProgrammingCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		// TODO Auto-generated method stub
		int[][] matriz=new int[denominations.length+1][totalValue+1];
		for (int i=0;i<denominations.length+1;i++) {
			for (int p=0; p<totalValue+1;p++) {
				if(p==0) {
					matriz[i][p]=0;
				} else if(i==0 && p>0) {
					matriz[i][p]=Integer.MAX_VALUE;
				} else if(i>0 && ((int) p/denominations[i-1])<=0) {
					matriz[i][p]=matriz[i-1][p];
				} else  {
					matriz[i][p]=Math.min((int)(p/denominations[i-1])+matriz[i-1][p%denominations[i-1]],matriz[i-1][p] );
				}
			}
		}
		
		int nOptimo=matriz[denominations.length][totalValue];
		int[] m=new int [denominations.length];
		int i=denominations.length;
		int p=totalValue;
		while (i>0) {
			int idx1=matriz[i-1][p];
			int idx2=matriz[i-1][p%denominations[i-1]]-p/denominations[i-1];
			
			
			if(idx2<idx1) {
				p=p%denominations[i-1];
			}
			int resta= matriz[i][p]-Math.min(idx1,idx2);
			m[i-1]=resta;
			i--;
		}
		return m;
		
	}

}

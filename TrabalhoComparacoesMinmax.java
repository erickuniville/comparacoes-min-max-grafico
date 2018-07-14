package complexidade.algoritmica;

public class TrabalhoComparacoesMinmax {

	public static void main(String[] args) {
		TrabalhoComparacoesMinmax x = new TrabalhoComparacoesMinmax();
		
		System.out.println("n;minmax1;minmax2 melhor;minmax2 pior;minmax2 media;minmax 3");
		for(int n=1; n<=100; n++) {
			int[] vetorCrescente = new int[n];
			int[] vetorDecrescente = new int[n];
			int[] vetorAleatorio = new int[n];
			
			x.popularVetorCrescente(vetorCrescente);
			x.popularVetorDecrescente(vetorDecrescente);
			x.popularVetorAleatorio(vetorAleatorio);
			
			int operacoesMinMax1       = x.minmax1(vetorCrescente);
			int operacoesMinMax2Melhor = x.minmax2(vetorCrescente);
			int operacoesMinMax2Pior   = x.minmax2(vetorDecrescente);
			int operacoesMinMax2Media  = x.minmax2(vetorAleatorio);
			int operacoesMinMax3       = x.minmax3(vetorCrescente);
			
			System.out.printf("%d;%d;%d;%d;%d;%d\n", n, operacoesMinMax1, operacoesMinMax2Melhor, operacoesMinMax2Pior, operacoesMinMax2Media, operacoesMinMax3);
		}
	}

	public int minmax1(int v[]) {
		int i;
		int min = v[0];
		int max = v[0];

		int operations = 2;

		for (i = 1; i < v.length; i++) {
			operations++;
			if (v[i] > max) {
				operations++;
				max = v[i];
			}

			operations++;
			if (v[i] < min) {
				operations++;
				min = v[i];
			}
		}

		return operations;
	}

	public int minmax2(int[] v) {
		int i;
		int min = v[0];
		int max = v[0];

		int operations = 2;

		for (i = 1; i < v.length; i++) {
			operations++;
			if (v[i] > max) {
				operations++;
				max = v[i];
			} else {
				operations++;
				if (v[i] < min) {
					operations++;
					min = v[i];
				}
			}
		}
		return operations;
	}

	public int minmax3(int v[]) {
		int i, a, b;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int operations = 2;

		operations++;
		if (v.length % 2 == 0) { // Tamanho PAR
			for (i = 0; i < v.length; i += 2) {
				operations++;
				if (v[i] < v[i + 1]) {
					operations += 1;
					a = i;
					b = i + 1;
				} else {
					operations += 1;
					a = i + 1;
					b = i;
				}

				operations++;
				if (v[a] < min) {
					operations++;
					min = v[a];
				}

				operations++;
				if (v[b] > max) {
					operations++;
					max = v[b];
				}
			}
		} else { // Tamanho ÍMPAR
			for (i = 0; i < v.length - 1; i += 2) {
				operations++;
				if (v[i] < v[i + 1]) {
					operations += 1;
					a = i;
					b = i + 1;
				} else {
					operations += 1;
					a = i + 1;
					b = i;
				}

				operations++;
				if (v[a] < min) {
					operations++;
					min = v[a];
				}

				operations++;
				if (v[b] > max) {
					operations++;
					max = v[b];
				}
			}

			operations++;
			if (v[i] < min) {
				operations++;
				min = v[i];
			}

			operations++;
			if (v[i] > max) {
				operations++;
				max = v[i];
			}
		}

		return operations;
	}

	public void popularVetorCrescente(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i;
		}
	}

	public void popularVetorDecrescente(int[] vetor) {
		int contador = 0;
		for (int i = vetor.length - 1; i >= 0; i--) {
			vetor[contador++] = i;
		}
	}

	public void popularVetorAleatorio(int[] vetor) {
		for(int i=0; i<vetor.length; i++) {
			vetor[i] = (int) (1000 * Math.random());
		}
	}

}

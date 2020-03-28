public class Buscas {
	
	public static int buscaLinearModificada (int vet[], int procurado) {
		int cont = 1;
		
        for(int i = 0; i < vet.length; i++) {
        	if(vet[i] == procurado)
        		return cont;
                cont++;           
         	}
        return -1;
	}   
    
	public static int buscaBinariaModificada (int vet[], int procurado) {
		int cont = 1;
        int inicio = 0;
        int fim = vet.length - 1;
        
        while(inicio <= fim) {
        	int meio = (inicio + fim) / 2;
                
            if(vet[meio] == procurado)
            	return cont;                    
            else
            	if (vet[meio] < procurado)
            		inicio = meio + 1;
            	else
            		fim = meio - 1;
            cont++;
        }
        
        return -1;
	}
          
	public static void main (String args[]) {
		int vet[] = new int[1000];
         
        for(int i=0; i<1000; i++) vet[i] = i;
         
        int tempoLinear = 0, 
        	tempoBinaria = 0, 
        	minLinear = Integer.MAX_VALUE, 
        	maxLinear = 0, 
        	minBinaria = Integer.MAX_VALUE, 
        	maxBinaria = 0;
         
        for(int i=0; i < 2000; i++) {
        	int aleatorio = (int) (Math.random()*1000);
        	
        	int resultBuscaLinear = buscaLinearModificada(vet, aleatorio);
        	int resultBuscaBinaria = buscaBinariaModificada(vet, aleatorio);
            tempoLinear += resultBuscaLinear;
            tempoBinaria += resultBuscaBinaria;
            
            if (resultBuscaLinear > maxLinear) maxLinear = resultBuscaLinear;
            if (resultBuscaLinear < minLinear) minLinear = resultBuscaLinear;
            if (resultBuscaBinaria > maxBinaria) maxBinaria = resultBuscaBinaria;
            if (resultBuscaBinaria < minBinaria) minBinaria = resultBuscaBinaria;
        }
         
        tempoLinear = tempoLinear/2000;
        tempoBinaria = tempoBinaria/2000;
      
        System.out.println ("Tempo médio da Busca Linear: " + tempoLinear);
        System.out.println ("Tempo médio da Busca Binária: " + tempoBinaria);
        System.out.println ("Tempo minimo da Busca Linear: " + minLinear);
        System.out.println ("Tempo minimo da Busca Binária: " + minBinaria);
        System.out.println ("Tempo máximo da Busca Linear: " + maxLinear);
        System.out.println ("Tempo máximo da Busca Binária: " + maxBinaria);
	}

}

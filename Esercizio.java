import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().

    static int rimuoviDuplicati(int[] V, int N, int[] O){
        int i, j;
        int M;

        M = N;
        i = 0;

        while(i <= N-2){
            j = i + 1;
            while(j <= N-1){
                if(V[i] == V[j]){
                    System.out.println("Elimino " + V[j] + " da cella" + j);
                    
                    N = eliminaDaVettore(V, N, j);
                    M = eliminaDaVettore(O, M, j);

                }else{
                    j++;
                }
            }
            i++;
        }
        return N;
    }

    static int inserisciInVettore(int[] V, int N, int e, int ie){
        int N2;
        N2 = N + 1;
        for(int i = N; i >= ie+1; i--){
            V[i] = V[i-1];
        }
        return N2;
    }

    static int eliminaDaVettore(int[] V, int N, int ie){
        int N2;
        N2 = N - 1;
        for(int i = ie; i < N - 1; i++){
            V[i] = V[i+1];
        }
        return N2;
    }

    static void visualizzaVettore(int[] V, int N, int[] O){
        int i;
        
        i = 0;
        
        System.out.println("peso: ");
        while(i < N){
            System.out.println(i + ": " + V[i]);
            i++;
        }

        i = 0;

        System.out.println("ora: ");
        while(i < N){
            System.out.println(i + ": " + O[i]);
            i++;
        }
    }

    public static void main(String args[]){

        Scanner in  = new Scanner(System.in);
        Random rand = new Random();
        
        int A, N, M, i, j, e, ora;
        
        System.out.print("Insersci il numero di pesci che saranno pescati: ");
        A = in.nextInt();

        int[] V = new int[A];
        int[] O = new int[A];

        N = 0;
        M = 0;
        i = 1;
        ora = 9;

        while(i <= A){
            e = (2 + rand.nextInt(9)) * 50;
            ora = (ora + 1) % 50;
            
            System.out.println("Il pesce pescato pesa: " + e);
            
            N = inserisciInVettore(V,N,e,N); 
            M = inserisciInVettore(O, M, e, M);

            j = 0;
            while(j < N){
                if(V[j] < V[N-1]){
                    System.out.println(V[j] + " scappa via");
                    N = eliminaDaVettore(V, N, j);
                    M = eliminaDaVettore(O, M, j);
                }else{
                    j++;
                }
            }

            System.out.println("Lago: ");
            visualizzaVettore(V, N, O);
            
            i++; 
        }

        N = rimuoviDuplicati(V, N, O);

        System.out.println("Animali con dimensioni diverse rimaste al lago: ");
        visualizzaVettore(V,N,O);
    }
}
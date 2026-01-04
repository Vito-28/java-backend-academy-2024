import java.util.Random;
import java.util.Scanner;

public class Lab {

    private Scanner input=new Scanner(System.in);

    public double leggiValoreDouble(String s) {
        System.out.println(s);
        return Double.parseDouble(input.nextLine()); //converto la stringa in double
    }

    public int leggiValore(String s) {

        System.out.println(s);
        return Integer.parseInt(input.nextLine()); //converto la stringa in intero

    }

    public String leggiStringa(String s) {
        System.out.println(s);
        return input.nextLine();

    }

    public void contatoreVerticale(int n) {
        if(n >= 0) {
            System.out.println("Conta in verticale da " + n + " a 0 in maniera decrescente: ");
            for(int i = n; i >= 0; i--) {
                System.out.println(i);
            }
        } else {
            System.out.println("Valore non valido.");
        }
    }

    public void contatoreOriz(int n) {

        if(n >= 0 && n<=100) {
            System.out.println("Conta in orizzontale i numeri pari in maniera crescente da " + n + " fino a " + 100 + ": ");
            int i = n;
            while(i < 100) {
                if(i%2==0) {
                    System.out.print(i + ", ");
                }
                i++;
            }
            System.out.println(i+".");
        } else {
            System.out.println("Valore non valido.");
        }

    }

    public void semaforo(String colore) {

        switch (colore.toLowerCase()) { //trasformo la stringa in minuscolo
            case "rosso":
                System.out.println("Fermati");
                break;
            case "giallo":
                System.out.println("Attenzione");
                break;
            case "verde":
                System.out.println("Prosegui");
                break;
            default:
                System.out.println("Non sei al semaforo");
        }

    }

    public String totalizzatore() {

        int valore, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, totale = 0, conta = 0;

        do {
            valore = leggiValore("Inserire un numero: ");

            conta++;

            if(valore<min) {
                min = valore;
            }

            if(valore>max) {
                max = valore;
            }

            totale += valore;

        }while(leggiStringa("Per continuare digita Si ").equalsIgnoreCase("si"));

        return "totale = "+totale+"\nmedia = " + (double)totale/conta + "\nmax = " + max + "\nmin = " + min;

    }

    public String occorrenzeVoc(String frase) {

        int countA = 0, countE = 0, countI = 0, countO = 0, countU =0, totCons = 0;

        //		frase = pulisciStringa(frase).toLowerCase();

        //tutto ciò che non è una lettera viene sostituito con una stringa vuota
        //attraverso l'uso di una regex che è una sequenza di caratteri
        //tutti i caratteri della stringa pulita vengono trasformati in minuscolo

        //		frase = frase.replaceAll("[^a-zA-Z]", "").toLowerCase();

        frase = frase.toLowerCase().replaceAll("[^a-z]", "");

        //		System.out.println(frase);

        for(int i = 0; i <= frase.length()-1; i++) {
            switch(frase.charAt(i)) {
                case 'a':
                    countA++;
                    break;
                case 'e':
                    countE++;
                    break;
                case 'i':
                    countI++;
                    break;
                case 'o':
                    countO++;
                    break;
                case 'u':
                    countU++;
                    break;
                default:
                    totCons++;
                    break;

            }
        }

        return "a:" + countA + " e:" + countE + " i:" + countI + " o:" + countO + " u:" + countU + " Totale Consonanti: " + totCons;
    }

    public String costruisciStringa(String frase) {

        frase = frase.replaceAll("[^a-zA-Z]", "");

        String caratteriPari = "", caratteriDispari = "";

        //l'operatore ternario:
        // condizione ? espr1 : espr2;

        for(int i = 0; i < frase.length(); i++) {

            if(i%2 == 0) {
                caratteriDispari += frase.charAt(i);
            } else {
                caratteriPari += frase.charAt(i);
            }


        }

        return "Stringa Pari : " + caratteriPari + " Stringa Dispari : " + caratteriDispari;
    }

    public void calcolatrice() {

        double risultato = 0, numero;
        System.out.println("Inserire prima un numero e poi una operazione da eseguire.");
        System.out.println("Inserisci + per sommare, - per sottrarre, / per dividere, * per moltiplica, = per il risultato finale");

        String operazione = "";

        risultato = leggiValore("Inserire un numero: ");

        do {

            operazione = leggiStringa("Inserire un'operazione: ");

            switch(operazione) {

                case "+":
                    numero = leggiValoreDouble("Inserire un numero: ");
                    risultato += numero;
                    System.out.println(risultato);
                    break;

                case "-":
                    numero = leggiValoreDouble("Inserire un numero: ");
                    risultato -= numero;
                    System.out.println(risultato);
                    break;

                case "*":
                    numero = leggiValoreDouble("Inserire un numero: ");
                    risultato *= numero;
                    System.out.println(risultato);
                    break;

                case "/":
                    numero = leggiValoreDouble("Inserire un numero: ");
                    if(numero != 0) {
                        risultato /= numero;
                        System.out.println(risultato);
                    } else {
                        System.out.println("Risultato Finale: ERROR impossibile dividere per 0 !!!");
                        operazione="=";
                    }
                    break;

                case "=":
                    System.out.println("Risultato Finale: " + risultato);
                    break;

                default:
                    System.out.println("Operatore non valido");
            }

        }while(!operazione.equals("="));

    }

    public void testVettore() {
        System.out.println("Testiamo il vettore: ");
        stampaVettore(inizializzaVettore(leggiValore("Inizializzare un vettore di interi con dimensione: ")));
    }

    public void trovaMaxVet(int[] vet) {

        int max = Integer.MIN_VALUE, indiceMax = 0;

        if(vet.length != 0) {

            /* Ricerca dell'indice del numero massimo nel vettore */
            for (int i = 0; i < vet.length; i++) {

                if(vet[i]>max) {
                    max = vet[i];
                    indiceMax = i;
                }

            }

            if(max == vet[0]) {
                return;
            } else {
                int tmp = vet[0];
                vet[0] = vet[indiceMax];
                vet[indiceMax] = tmp;
            }

        }

    }

    public int trovaIndiceMax(String[] vet, String nominativo) {
        int indiceMax = -1;

        if(vet != null) {
            for(int i = 0; i < vet.length; i++) {
                if(vet[i].equalsIgnoreCase(nominativo)) {
                    indiceMax = i;
                }
            }
        }

        return indiceMax;
    }

    public boolean palindroma(String frase) {

        frase = frase.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for(int i = 0; i < frase.length()/2; i++) {
            if(frase.charAt(i) != frase.charAt((frase.length()-1)-i)) {
                return false;
            }
        }

        return true;

    }

    public String[] ricercaStringAscii(String[] vet, String nominativo) {

        int codAscii = calcolaCodiceAscii(nominativo);
        String tmp = "";

        if(vet.length > 0) {

            for(int i = 0; i < vet.length; i++) {
                if(codAscii == calcolaCodiceAscii(vet[i])) {
                    tmp += vet[i] +",";
                }
            }

//			if(tmp.isEmpty()) {
//				return null;
//			}

            return tmp.split(",");

        } else {
            return null;
        }

    }

    public int calcolaCodiceAscii(String parola) {

        int sommAscii = 0;
        if(parola != null) {
            for(int i = 0; i < parola.length(); i++) {
                sommAscii += parola.charAt(i);
            }
        }
        return sommAscii;

    }

    public String[] ordinaNominativi(String[] vet, String ordinamento) {

        boolean ascendente = ordinamento.equalsIgnoreCase("ascendente");

        // Antonio Luca Anna Federico
        // i = 0 Anna Luca Antonio Federico
        //        i=0 j=1
        // i = 1 Anna Antonio Luca Federico
        //                     j=2
        // i = 2 Anna Antonio Federico Luca
        //                      i=2     j=3
        // i = 3 out


        for(int i = 0; i < vet.length - 1; i++) {
            for(int j = i+1; j < vet.length; j++) {
                if((ascendente && vet[i].compareTo(vet[j]) > 0) || (!ascendente && vet[i].compareTo(vet[j])< 0)) { // vet[i]>vet[j] oppure vet[i]<vet[j]
                    String tmp = vet[i];
                    vet[i] = vet[j];
                    vet[j] = tmp;
                }
            }
        }

        return vet;

    }

    public int[] ordinaNumeri(int[] vet, String ordinamento) {

        boolean crescente = ordinamento.equalsIgnoreCase("crescente");

        for(int i = 0; i < vet.length-1; i++) {
            for(int j = i+1; j < vet.length; j++) {
                if((crescente && vet[i]>vet[j]) || (!crescente && vet[i]<vet[j])) {
                    int tmp = vet[i];
                    vet[i] = vet[j];
                    vet[j] = tmp;
                }
            }
        }

        return vet;
    }

    public int[][] trovaMaxRiga(int[][] mat) {

        int max, indiceMax = 0;

        for(int i = 0; i < mat.length; i++) {
            max = Integer.MIN_VALUE;

            for(int j = 0; j < mat.length; j++) {
                if(mat[i][j] > max) {
                    indiceMax = j;
                }
            }

            if(max != mat[i][0]) {
                mat[i][indiceMax] = mat[i][0];
                mat[i][0] = max;
            }

        }

        return mat;

    }

    public int[] inizializzaVettore(int dim) {

        int[] vet = new int[dim];

        if(vet.length > 0) {
            for(int i = 0; i < vet.length; i++) {
                vet[i] = leggiValore("Inserisci un numero intero in posizione " + i);
            }
        }

        return vet;
    }

    public String[] inizializzaVetString(int dim) {
        String[] vet = new String[dim];

        if(vet.length != 0) {
            for(int i = 0; i < vet.length; i++) {
                vet[i] = leggiStringa("Inserisci un nominativo in posizione " + i);
            }
        }

        return vet;
    }

    public double[][] inizializzaMeteoMatrice() {
        double[][] mat = new double[7][4];
        double max = 45, min = -20;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                mat[i][j] = ((Math.random() * (max - min)) + min);
            }
        }

        return mat;
    }

    public void stampaReportMeteo(double[][] mat) {

        String[] giorni = new String[]{"LU","MA","ME","GI","VE","SA","DO"};
        String[] ore = new String[] {"06.00","12.00","18.00","24.00"};

//		System.out.print("    ");
//		for(int o = 0; o < ore.length; o++) {
//			System.out.print(ore[o] + "    ");
//		}
//		System.out.println();
//
//		for(int i = 0; i < giorni.length; i++) {
//			System.out.print(giorni[i] + "  ");
//			System.out.printf("%3s ", giorni[i]);
//			for(int j = 0; j < mat[0].length; j++) {
//				System.out.printf("%6.2f", mat[i][j]);
//			}
//			System.out.println();
//		}

        //Stampiamo le ore separatamente
        System.out.printf("%-4s", " "); //Stampa una cella vuota in alto a sinistra
        for (String ora : ore) {
            System.out.printf(" %8s ", ora); //Stampiamo le ore
        }
        System.out.println();

        //Stampiamo la matrice
        for (int i = 0; i < mat.length; i++) {
            System.out.printf("%3s ", giorni[i]); //Per ogni riga stampiamo prima il giorno
            for (int j = 0; j < mat[i].length; j++) {
                //Stampiamo i valori
                System.out.printf("%8.2f° ", mat[i][j]);

            }
            System.out.println();

        }
        System.out.println();

        double massimo = Double.MIN_VALUE, minimo = Double.MAX_VALUE;
        int oraMax = 0, giornoMax = 0, oraMin = 0, giornoMin = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > massimo) {
                    massimo = mat[i][j];
                    oraMax = j;
                    giornoMax = i;
                }
                if (mat[i][j] < minimo) {
                    minimo = mat[i][j];
                    oraMin = j;
                    giornoMin = i;
                }
            }
        }

        System.out.printf("%nLa temperatura minima di %.2f° è stata percepita %s alle ore %s.%n", minimo, giorni[giornoMin], ore[oraMin]);
        System.out.printf("La temperatura massima di %.2f° è stata percepita %s alle ore %s.%n", massimo, giorni[giornoMax], ore[oraMax]);

    }

    public int[][] inizializzaMatriceRandom(int righe, int colonne) {
        int[][] mat = new int[righe][colonne];

        Random random = new Random();

        int min = -100, max = 100;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = random.nextInt(max-min+1) + min; //genera un numero intero casuale tra 0 (incluso) e (max-min) (escluso)
                //sommando +1 possiamo includere il max nel range
                // somma il minimo per spostare l'intervallo nella posizione min.
            }
        }

        return mat;
    }

    public void stampaMatrice(int[][] mat) {

        System.out.println("Stampa della Matrice di interi: ");

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void stampaVettore(int[] vet) {

        System.out.println("Stampa del vettore di interi: ");
        String stampa = "";

        if(vet.length == 1) {
            System.out.println("[" + vet[0] + "]");
        } else if(vet.length > 1) {
            for(int i = 0; i < vet.length; i++) {

                //				if(i == 0) {
                //					System.out.print("[" + vet[i] + ", ");
                //				} else if(i == vet.length-1) {
                //					System.out.print(vet[i] + "]");
                //				} else {
                //					System.out.print(vet[i] + ", ");
                //				}

                stampa += ( (i == 0) ? ("[" + vet[i] + ", ") : (i == vet.length-1) ? (vet[i] + "]") : (vet[i] + ", ") );
            }
            System.out.println(stampa);
        } else {
            System.out.println("[ARRAY VUOTO]");
        }
    }

    public void stampaVettore(String[] vet) {
        System.out.println("Stampa del vettore di stringhe: ");
        String stampa = "";

        if(vet.length == 1) {
            System.out.println("[" + vet[0] + "]");
        } else if(vet.length > 1) {
            for(int i = 0; i < vet.length; i++) {

                //				if(i == 0) {
                //					System.out.print("[" + vet[i] + ", ");
                //				} else if(i == vet.length-1) {
                //					System.out.print(vet[i] + "]");
                //				} else {
                //					System.out.print(vet[i] + ", ");
                //				}

                stampa += ( (i == 0) ? ("[" + vet[i] + ", ") : (i == vet.length-1) ? (vet[i] + "]") : (vet[i] + ", ") );
            }
            System.out.println(stampa);
        } else {
            System.out.println("[ARRAY VUOTO]");
        }

    }

    public int menu() {

        System.out.println("***MENU***");
        System.out.println("1) contatoreVerticale");
        System.out.println("2) contatoreOriz");
        System.out.println("3) semaforo");
        System.out.println("4) totalizzatore");
        System.out.println("5) occorrenzeVoc");
        System.out.println("6) costruisciStringa");
        System.out.println("7) calcolatrice");
        System.out.println("8) testVettore");
        System.out.println("9) trovaMaxVet");
        System.out.println("10) trovaIndiceMax ");
        System.out.println("11) palindroma");
        System.out.println("12) ricercaStringAscii");
        System.out.println("13) ordinaNominativi");
        System.out.println("14) trovaMaxRiga");
        System.out.println("15) reportMeteo");

        System.out.println("0) ESCI");
        //		int scelta=leggiValore();
        //		return scelta;

        return leggiValore("Fai una scelta: ");
    }

}

//public String pulisciStringa(String s) {
//String tmp = "";
//for(int i = 0; i < s.length(); i++) {
//	if(Character.isLetter(s.charAt(i))) {
//		tmp += ""+s.charAt(i);
//	}
//}
//
//return tmp;
//}

//	public int[] trovaMaxVet(int[] vet) {
//
//		int max = Integer.MIN_VALUE, indiceMax = 0;
//
//		for (int i = 0; i < vet.length; i++) {
//
//			/* controlla se l'elemento è massimo */
//			if(vet[i]>max) {
//
//				/* variabile che tiene traccia del massimo nella ricerca */
//				max = vet[i];
//
//				/* scambia il massimo in prima posizione*/
//				int tmp = vet[0];
//				vet[0] = vet[i];
//				vet[i] = tmp;
//
//			}
//
//		}
//
//		return vet;
//	}

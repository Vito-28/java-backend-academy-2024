
public class Start {

    public static void main(String[] args) {

        boolean flag=true;
        Lab l=new Lab();


        //	--->riparte
        do {
            switch (l.menu()) {
                case 1:
                    //eseguo contatoreVerticale
                    l.contatoreVerticale(l.leggiValore("Inserisci un numero intero: "));
                    break;
                case 2:
                    //eseguo contatoreOriz
                    l.contatoreOriz(l.leggiValore("Inserisci un numero intero compreso nell'intervallo [0,100]: "));
                    break;
                case 3:
                    //eseguo semaforo
                    l.semaforo(l.leggiStringa("Inserisci un colore: verde/giallo/rosso: "));
                    break;
                case 4:
                    //eseguo totalizzatore
                    System.out.println(l.totalizzatore());
                    break;
                case 5:
                    //eseguo occorrenzeVoc
                    System.out.println(l.occorrenzeVoc(l.leggiStringa("Inserisci una frase: ")));
                    break;
                case 6:
                    //eseguo costruisciStringa
                    System.out.println(l.costruisciStringa(l.leggiStringa("Inserisci una frase: ")));
                    break;
                case 7:
                    //eseguo calcolatrice7
                    l.calcolatrice();
                    break;
                case 8:
                    //eseguo testVettore
                    l.testVettore();
                    break;

                case 9:
                    //eseguo trovaMaxVet
                    int[] vet = l.inizializzaVettore(l.leggiValore("Inserisci una dimensione per il vettore di interi: "));
                    l.stampaVettore(vet);
                    l.trovaMaxVet(vet);
                    l.stampaVettore(vet);
                    break;

                case 10:
                    //eseguo trovaIndiceMax
                    String[] vet1 = l.inizializzaVetString(l.leggiValore("Inserisci una dimensione per il vettore di stringhe: "));
                    int indice = l.trovaIndiceMax(vet1, l.leggiStringa("Inserisci il nominativo da cercare nel vettore di nominativi: "));

                    if(indice == -1) {
                        System.out.println("Non sono presenti nominativi nel vettore.");
                    } else {
                        System.out.println("Il nominativo è stato trovato all'indice " + indice + " ed il suo valore è " + vet1[indice]);
                    }

                    break;

                case 11:
                    //eseguo palindroma
                    if(l.palindroma(l.leggiStringa("Inserisci una frase: "))) {
                        System.out.println("La frase è palindroma.");
                    } else {
                        System.out.println("La frase non è palindroma.");
                    }

                    break;

                case 12:
                    //eseguo ricercaStringAscii
                    //{"Mario","Lucio","Giorg","Guido"}  "Mario"
                    String[] vett = l.inizializzaVetString(l.leggiValore("Inserisci una dimensione per il vettore di stringhe: "));
                    l.stampaVettore(vett);
                    String[] vett2 = l.ricercaStringAscii(vett, l.leggiStringa("Inserisci un nominativo: "));

                    if(vett2 != null)
                        l.stampaVettore(vett2);
                    else
                        System.out.println("Non ci sono nominativi con lo stesso codice ascii");

                    break;

                case 13:
                    //eseguo ordinaNominativi
                    String[] vettore = l.inizializzaVetString(l.leggiValore("Inserisci una dimensione per il vettore di nominativi: "));

                    if(vettore != null && vettore.length > 0) {
                        l.stampaVettore(vettore);
                        l.stampaVettore(l.ordinaNominativi(vettore, l.leggiStringa("Scegli tra ordine Ascendente/Discendente: ")));
                    } else {
                        System.out.println("Error");
                    }

                    break;

                case 14:
                    //esegup trovaMaxRiga
                    int[][] matrix = l.inizializzaMatriceRandom(l.leggiValore("Inserisci righe: "),l.leggiValore("Inserisci colonne: "));
                    if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
                        l.stampaMatrice(matrix);
                        l.stampaMatrice(l.trovaMaxRiga(matrix));
                    } else {
                        System.out.println("Error");
                    }
                    break;

                case 15:
                    //eseguo reportMeteo
                    double[][] mat = l.inizializzaMeteoMatrice();
                    l.stampaReportMeteo(mat);

                    break;

                case 0:
                    //USCITA!
                    flag=false;
                    System.out.println("FINE PROGRAMMA!");
                    break;
                default:
                    //VALORE NON VALIDO!
                    System.out.println("SCELTA NON VALIDA!");
                    break;
            }

        }while(flag);


    }

}

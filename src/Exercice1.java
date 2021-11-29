
import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {


    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        System.out.println("entrer nb ligne de la première matrice");
        int ligne = print.nextInt();
        System.out.println("entrer nb colonne de la première matrice");
        int colonne = print.nextInt();
       // System.out.println("entrer nb ligne de la deuxième matrice");
        //int ligne2 = print.nextInt();
        //System.out.println("entrer nb colonne de la deuxième matrice");
        //int colonne2 = print.nextInt();
        int[][] tab = new int[ligne][colonne];
        //int[][] tab2 = new int[ligne2][colonne2];

        System.out.println("mettre valeur dans la matrice 1");
        addvaluemat(tab);
        sommediago(tab);
        /*System.out.println("mettre valeur dans la matrice 2");
        addvaluemat(tab2);
        affichermatrice(tab);
        affichermatrice(tab2);
        produitmatrice(tab, tab2);
*/
        //carre_magique(3);

        //countnullelement(tab);
        //havenull(tab);

        //System.out.println("tab=");
        //affichermatrice(tab);
        /*System.out.println("tab2=");
        affichermatrice(tab2);*/
        //sommediago(tab);
        /*System.out.println("addition de matrice en cours");
        additionm(tab,tab2);
        System.out.println("adddition terminée");*/
    }

    public static int[][] additionm(int[][] matrice, int[][] matrice2) {


        int[][] result = new int[matrice.length][matrice.length];//pour l'addition elles doivent être de même longueur
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[j].length; j++) {
                result[i][j] = matrice[i][j] + matrice2[i][j];
            }
        }

        return result;

    }

    public static void affichermatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] addvaluemat(int[][] matrice) {
        Scanner print = new Scanner(System.in);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                int value = print.nextInt();
                matrice[i][j] = value;
            }
        }

        return matrice;
    }

    public static int sommediago(int[][] matrice) {
        int resultdiagodroite = 0;
        int resultdiagogauche = 0;
        int k = matrice.length - 1;
        for (int i = 0; i < matrice.length; i++) {  //On ne fait que les càs où i=j
            resultdiagodroite = resultdiagodroite + matrice[i][i];// i = j donc
        }

        for (int l = 0; l < matrice.length; l++) { // cas diago gauche
            resultdiagogauche = resultdiagogauche + matrice[l][k];
            k--;
        }
        System.out.println("diagonal droite=" + resultdiagodroite);
        System.out.println("diagonal gauche=" + resultdiagogauche);
        resultdiagogauche = resultdiagogauche + resultdiagodroite;
        System.out.println("somme diago=" + resultdiagogauche);
        return resultdiagogauche;
    }

    public static boolean havenull(int[][] matrice) {
        boolean havenull = false;
        for (int i = 0; i < matrice.length; i++) { //on est plus rapide si dès qu'on a un elemt qui est diffenrets de null, on change
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 0) { //le bool plutôt que de tout parcourir
                    havenull = !havenull;
                    System.out.println(havenull);
                    return havenull; //parcourt partiel, dès qu'on trouve l'élément qon sort de la fonction
                }
            }
        }
        System.out.println(havenull);
        return havenull;
    }

    public static int countnullelement(int[][] matrice) {
        int counter = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
        return counter;
    }

    public static int whitchline(int[][] matrice) {
        int counter = 0;
        int maxdindex = 0;
        int[] result = new int[matrice.length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 0) {
                    counter++;
                }
                result[i] = counter;
            }
            maxdindex = getmaxindex(result) + 1;
        }
        System.out.println("la ligne qui contient le plus de 0 est la :" + maxdindex);
        return maxdindex;
    }

    public static int getmaxindex(int[] tab) {
        int maxindex = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i + 1] > tab[i]) {
                maxindex++;
            }

        }

        return maxindex;
    }

    public static int produitmatrice(int[][] matrice, int[][] matrice2) {
        int result = 0;
        int valuemat1 = 0;
        int valuemat2 = 0;


        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {//parcours de la première matrice
                valuemat1 = matrice[i][j];
                for (int k = 0; k < matrice2[i].length; k++) {//parcours de la deuxième matrice

                    valuemat2 = matrice2[j][k];
                    result = result + (valuemat1 * valuemat2);


                }
            }
            System.out.println("result=" + result);
        }

        return result;
    }

    public static int[][] carre_magique(int n) {
        Scanner print = new Scanner(System.in);
        int ligne;
        int colonne;
        int mediane;
        int valeur = 2;
        boolean reached = false;
        boolean finsh = false;


        System.out.println("entre dimension n");
        ligne = print.nextInt();
        colonne = ligne;
        int[][] matrice = new int[ligne][colonne];

        for (int i = 0; i < matrice.length; i++) { //0 dans toutes les cases
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = 0;
            }
        }


        mediane = (1 + (matrice.length)) / 2;
        matrice[0][mediane] = 1;








        return matrice;
    }
}
package rs.nmarinkovic.combinations;

import java.util.Scanner;

public class Main
{
    static void printIndex(MyPair[] niz) {
        for(int i = 0; i < niz.length; i++) {
            System.out.print(niz[i].getIndex() + " ");
        }
        System.out.println();
    }
    static void printValue(MyPair[] niz) {
        for(int i = 0; i < niz.length; i++) {
            System.out.print(niz[i].getValue() + " ");
        }
        System.out.println();
    }
    static MyPair[] reorderPairArray(MyPair[] niz)
    {
        MyPair[] newArr = new MyPair[niz.length];
        for (int i = 0; i < niz.length; i++)
        {
            newArr[i] = new MyPair(niz[niz.length - i - 1]);
        }
        return newArr;
    }
    static Boolean arePairsEqual(MyPair[] array1, MyPair[] array2) {
        for(int i = 0; i < array1.length; i++) {
            if(array1[i].getIndex() != array2[i].getIndex())  {
                return false;
            }
        }
        return true;
    }
    static void allCombinations(int n) {
        System.out.println("Insert names of all elements: ");
        Scanner scanner = new Scanner(System.in);
        if(n == 1) {
            String ns123 = scanner.nextLine();
            System.out.println("List of all combinations:");
            System.out.println(ns123);
        }
        else {

            MyPair[] jednakomb = new MyPair[n];
            for(int i = 1; i <= n; i++) {
                //Scanner scanner = new Scanner(System.in);
                String ns = scanner.nextLine();
                jednakomb[i-1] = new MyPair(i, ns);
            }

            System.out.println("List of all combinations:");
            printValue(jednakomb);

            MyPair[] prvobitnareordered = reorderPairArray(jednakomb);

            while(!arePairsEqual(jednakomb, prvobitnareordered))
            //while (!Arrays.equals(jednakomb, prvobitnareordered))
            {
                // ide unazad po kombinaciji
                for (int j = n - 2; j >= 0; j--)
                {
                    // poredi onu na kojom smo sa prethodnom, i ako je prethodna veca onda radi stvari
                    if (jednakomb[j].getIndex() < jednakomb[j + 1].getIndex())
                    {

                        int najmanjieliza = n + 1;
                        int indexnajmanjeg = j;
                        Boolean postojiManji = false;

                        // pronadje sledeci element sa kojime ce da se zameni
                        // (on je prvi najmanji ali nije manji od njega, bitan detalj, u suprotnom ce se vrteti iste vrednosti)
                        for (int k = j + 1; k < n; k++)
                        {
                            if (jednakomb[k].getIndex() > jednakomb[j].getIndex())
                            {
                                if (najmanjieliza > jednakomb[k].getIndex())
                                {
                                    najmanjieliza = jednakomb[k].getIndex();
                                    indexnajmanjeg = k;
                                    postojiManji = true;
                                }
                            }
                        }

                        // razmena vrednosti na ta 2 indeksa
                        if(postojiManji==true) {
                            MyPair temp = new MyPair(jednakomb[j]);
                            jednakomb[j] = jednakomb[indexnajmanjeg];
                            jednakomb[indexnajmanjeg] = temp;
                        }

                        // niz svih elemenata nakon onog na kom smo stali
                        // trebace nam da ga okrenemo

                        int arrAfterLength = n - j - 1;

                        MyPair[] niz_iza = new MyPair[arrAfterLength];

                        for (int k = 0; k < arrAfterLength; k++)
                        {
                            niz_iza[k] = new MyPair(jednakomb[k + j + 1]);
                        }

                        // okrecemo ceo niz
                        //int[] niz_iza_reordered = new int[niz_iza.length];
                        //niz_iza_reordered = reorderel(niz_iza);

                        MyPair[] niz_iza_reordered = reorderPairArray(niz_iza);


                        // stavljamo okrenut niz
                        for (int lj = 0; lj < arrAfterLength; lj++)
                        {
                            jednakomb[lj + j + 1] = niz_iza_reordered[lj];
                        }
                        printValue(jednakomb);
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.print("Provide the number of elements your set has: ");
        Scanner scanner = new Scanner(System.in);
        String ns = scanner.next();
        int n = 0;
        try
        {
            n = Integer.parseInt(ns);
        } catch (NumberFormatException e)
        {
            n = 4;
        }

        if (n == 0) return;
        if (n < 0) n = n * -1;

        allCombinations(n);

        System.out.println("Hello world!");
    }
}
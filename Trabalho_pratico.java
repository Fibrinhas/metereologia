import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trabalho_pratico {
    public static Scanner sc = new Scanner(System.in);
    public static final String informacaoTerreno = sc.nextLine();
    public static final int L = sc.nextInt();
    public static final int C = sc.nextInt();
    public static final int[] niveis = {20, 30, 40};
    public static final String[] avisos = {"moderate", "high", "extreme", "catastrophic"};
    public static final String[] avisosIniciais = {"M", "H", "E", "C"};

    static final String FILE1 = "Inserir_informacao";
    static final String FILE2 = "Output";

    public static void main(String[] args) throws FileNotFoundException {
        //readFromFile(FILE1, FILE2);
        int[][] MT = new int[L][C];
        String[][] MA = new String[L][C];
        inserirTemperaturasPorRegiao(MT);

        System.out.println("b)");
        alinhadoDireitaMT(MT);
        System.out.println("c)");
        definirAlertasPorRegiao(MT, MA);
        mostrarIniciaisAlertas(MT, MA);
        System.out.println("d)");

    }


    /*public static void readFromFile(String file, String file2)
            throws FileNotFoundException {
        String informacaoTerreno = sc.nextLine();
        int l = sc.nextInt();
        int c = sc.nextInt();
        Scanner scanner = new Scanner(new File(file2));
        int[][] MT = new int[l][c];

        for (int i = 0; i < MT.length && scanner.hasNextInt(); i++) {
            for (int j = 0; j < MT[0].length && scanner.hasNextInt(); j++) {
                MT[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int L = sc.nextInt();
        int C = sc.nextInt();
        Scanner in2 = new Scanner(new File(file));
        int[][] MT = new int[L][C];
        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MT[0].length; j++) {
                MT[i][j] = in2.nextInt();
            }
        }
        in2.close();
    }*/

    public static void inserirTemperaturasPorRegiao(int[][] MT) {
        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MT[0].length; j++) {
                MT[i][j] = sc.nextInt();
            }
        }
    }

    public static void alinhadoDireitaMT(int[][] MT) {
        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MT[0].length; j++) {
                System.out.printf("%4d", MT[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void definirAlertasPorRegiao(int[][] MT, String[][] MA) {
        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MT[0].length; j++) {
                verificadorNiveis(MT, MA, i, j);
            }
        }
    }

    public static void verificadorNiveis(int[][] MT, String[][] MA, int i, int j) {
        int cont = 0;
        boolean verificadorNivel = false;
        while (cont < niveis.length && !verificadorNivel) {
            if (MT[i][j] < niveis[cont]) {
                verificadorNivel = true;
                MA[i][j] = avisosIniciais[cont];
            }
            cont++;
            if (!verificadorNivel) {
                MA[i][j] = avisosIniciais[cont];
            }
        }
    }

    public static void mostrarIniciaisAlertas(int[][] MT, String[][] MA) {
        for (int i = 0; i < MT.length; i++) {
            for (int j = 0; j < MT[0].length; j++) {
                System.out.print(MA[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /*definir uma área do terreno da seguinte forma:
    - 1ª linha – texto descritivo do terreno, data e hora da captura da informação;
    - 2ª linha - dois inteiros (L e C), separados por um espaço, indicando a dimensão do terreno em linhas (L) e colunas (C);
    - L linhas, cada uma contendo C números inteiros representativos da temperatura nessa área de terreno,
    separados por um espaço.*/
}
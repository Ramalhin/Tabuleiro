import java.util.Scanner;

public class Tabuleiro {

    static int linha = 1;
    static int coluna = 1;

    public static void main(String[] args) {
        Posicao posicaoInicial = new Posicao(1, 1);
        Sala salaInicial = new Sala();
        salaInicial.criar(posicaoInicial);

        System.out.print("Digite a posição desejada: [d = direita, b = baixo, c = cima, e = esquerda] ");
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            char c = sc.next().charAt(0);
            switch (c) {
                case 'd':
                    if (coluna >= Sala.TAMANHO_DA_SALA) {
                        break;
                    } else {
                        coluna++;
                    }
                    break;
                case 'e':
                    if (coluna <= 1) {
                        break;
                    } else {
                        coluna--;
                    }
                    break;
                case 'b':
                    if (linha >= Sala.TAMANHO_DA_SALA) {
                        break;
                    } else {
                        linha++;
                    }
                    break;
                case 'c':
                    if (linha <= 1) {
                        break;
                    } else {
                        linha--;
                    }
                    break;
                default:
                    System.out.println("Tecla Invalida, utilize [e, d, b ou c]");
                    break;
            }

            Posicao posicao = new Posicao(linha, coluna);
            Sala sala = new Sala();
            sala.criar(posicao);
        }
    }

    static class Sala {

        public static final int TAMANHO_DA_SALA = 3;

        void criar(Posicao posicao) {
            for (int i = 1; i <= TAMANHO_DA_SALA; i++ ) {
                System.out.println("\n");
                for (int j = 1 ; j <= TAMANHO_DA_SALA; j++ ) {
                    if (i == posicao.getLinha() && j == posicao.getColuna()) {
                        System.out.print(" o");
                    } else {
                        System.out.print(" x");
                    }
                }
            }
            System.out.println("\n");
        }
    }

    static class Posicao {
        int linha;
        int coluna;

        public Posicao(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        public int getLinha() {
            return linha;
        }

        public int getColuna() {
            return coluna;
        }
    }

}

package Projeto.java.Gerencialmento.Dominio;

import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Livro[] livros = new Livro[5];
        int opcao = 1;
        int posicao = 0;

        Scanner scanner = new Scanner(System.in);
        while (opcao != 4) {
            System.out.println("\n1 - Cadastrar Livro ");
            System.out.println("2 - Listagem Livro ");
            System.out.println("3 - Busca Livro ");
            System.out.println("4 - sair ");
            System.out.print("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("OPÇÃO INVÁLIDA!");
                scanner.nextLine();
            }

            opcao = scanner.nextInt();
            if (opcao == 1) {
                if (posicao < livros.length) {
                    livros[posicao] = new Livro();

                    scanner.nextLine();
                    String nomeLivro = lerTextoObrigatorio(scanner, "\nDigite o nome do livro: ", "INFORME O NOME DO LIVRO!" );
                    livros[posicao].nomeLivro = nomeLivro;
                    System.out.println("Livro cadastrado: ["+ livros[posicao].nomeLivro +"]" );

                    String nomeAutor = lerTextoObrigatorio(scanner, "\nDigite o nome do Autor: ", "INFORME O NOME DO AUTOR!");
                    livros[posicao].nomeAutor = nomeAutor;
                    System.out.println("Autor cadastrado: [" +  livros[posicao].nomeAutor + "]");

                    String codigoLivro = lerTextoObrigatorio(scanner, "\nDigite o código do livro: ", "INFORME O CÓDIGO!");
                    livros[posicao].codigoLivro = codigoLivro;
                    System.out.println("Código cadastrado: [" + livros[posicao].codigoLivro + "]");


                    livros[posicao].generoLivro = escolherGenero(scanner);
                    System.out.println("\nGênero cadastrado: [" + livros[posicao].generoLivro + "]");

                    System.out.println("\nCadastro de livro realizado! ");

                    posicao++;

                }else{
                    System.out.println("Não é possível cadastrar mais livros. Limite atingido. ");
                }

            } else if (opcao == 2) {
                for (int i = 0; i < posicao; i++) {
                    exibirLivro(livros[i]);
                }

            } else if (opcao == 3) {
                System.out.println("\n1 - Buscar por código  ");
                System.out.println("2 - Buscar por nome  ");
                scanner.nextLine();
                System.out.print("\nEscolha uma opção: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("OPÇÃO INVÁLIDA! DIGITE APENAS 1 ou 2 ");
                    scanner.nextLine();
                }
                int opcaoBusca = scanner.nextInt();

                if (opcaoBusca == 1) {
                    buscarLivro(scanner, livros,"Digite o Código: ", posicao, opcaoBusca);

                } else if (opcaoBusca == 2) {
                    buscarLivro(scanner, livros,"Digite o nome: ", posicao, opcaoBusca );

                } else {
                    System.out.println("OPÇÃO INVÁLIDA! SELECIONE 1 OU 2.");
                }

            } else if (opcao == 4) {
                System.out.println("Saindo do Sistema...");

            } else {
                System.out.println("Opção invalida ");
            }
       }
    }
    static void exibirLivro(Livro livro){

        System.out.println("\nNome do livro: [" + livro.nomeLivro + "]");
        System.out.println("Autor do livro: [" + livro.nomeAutor + "]");
        System.out.println("Código do livro: [" + livro.codigoLivro + "]");
        System.out.println("Gênero do livro: [" + livro.generoLivro + "]");
    }

    static String lerTextoObrigatorio(Scanner scanner, String pedido, String erro ){
        System.out.print(pedido);
        String texto = scanner.nextLine();
        while (texto.trim().isEmpty()){
            System.out.println(erro);
            texto = scanner.nextLine();
        }
        return texto.trim();
    }

    static void buscarLivro(Scanner scanner, Livro[] livros, String pedido, int posicao, int opcaoBusca ){
        System.out.print(pedido);
        scanner.nextLine();
        String termoBusca = scanner.nextLine().trim();
        boolean encontrou = false;
        for (int i = 0; i < posicao; i++) {
            String valorComparado;

            if (opcaoBusca == 1){
                valorComparado = livros[i].codigoLivro;

            }else {
                valorComparado = livros[i].nomeLivro;
            }
            if (termoBusca.equals(valorComparado)){
                encontrou = true;
                System.out.println("\n ------ LIVRO ENCONTRADO ------ ");
                exibirLivro(livros[i]);
                break;

            }
        }
        if (!encontrou) {
            System.out.println("\n ------ LIVRO NÃO ENCONTRADO ------ ");
        }

    }

    static GeneroLivro escolherGenero(Scanner scanner){
        System.out.println("\nEscolha o gênero: ");
        int escolhaGenero = 0;
        for (int i = 0; i < GeneroLivro.values().length; i++) {
            System.out.println((i + 1) + " - "  + GeneroLivro.values()[i]);
        }
        System.out.print("Digite a opção desejada: ");

        while (escolhaGenero < 1 || escolhaGenero >  GeneroLivro.values().length) {

            while (!scanner.hasNextInt()) {
                System.out.println("\nOPÇÃO INVÁLIDA!");
                scanner.nextLine();
                System.out.print("Escolha uma opção válida: ");
            }
            escolhaGenero = scanner.nextInt();
            scanner.nextLine();

            if (escolhaGenero < 1 || escolhaGenero >  GeneroLivro.values().length){
                System.out.println("\nOPÇÃO INVÁLIDA!");
                System.out.print("Escolha uma opção válida: ");
            }

        }
          return GeneroLivro.values()[escolhaGenero - 1];
    }

}

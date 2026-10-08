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
            System.out.println("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("OPÇÃO INVÁLIDA!");
                scanner.nextLine();
            }

            opcao = scanner.nextInt();
            if (opcao == 1) {
                if (posicao < livros.length) {
                    livros[posicao] = new Livro();

                    scanner.nextLine();
                    String nomeLivro = lerTextoObrigatorio(scanner, "Digite o nome do livro:", "INFORME O NOME DO LIVRO!");
                    livros[posicao].nomeLivro = nomeLivro.trim();
                    System.out.println("Livro cadastrado: " + nomeLivro);

                    String nomeAutor = lerTextoObrigatorio(scanner, "\nDigite o nome do Autor: ", "INFORME O NOME DO AUTOR!");
                    livros[posicao].nomeAutor = nomeAutor.trim();
                    System.out.println("Autor cadastrado: " + nomeAutor);

                    String codigoLivro = lerTextoObrigatorio(scanner, "\nDigite o código do livro: ", "INFORME O CÓDIGO!");
                    livros[posicao].codigoLivro = codigoLivro;
                    System.out.println("Código cadastrado: " + codigoLivro);

                    String generoLivro = lerTextoObrigatorio(scanner, "\nDigite o gênero do livro: ", "INFORME O GÊNERO!");
                    livros[posicao].generoLivro = generoLivro;
                    System.out.println("Gênero cadastrado: " + generoLivro);

                    System.out.println("Cadastro de livro ");

                    posicao++;

                }else{
                    System.out.println("Não é possível cadastrar mais livros. Limite atingido. ");
                }

            } else if (opcao == 2) {
                for (int i = 0; i < posicao; i++) {
                    exibirLivro(livros[i]);
                }

            } else if (opcao == 3) {
                System.out.println("1 - Buscar por código:  ");
                System.out.println("2 - Digite por nome:  ");
                scanner.nextLine();

                while (!scanner.hasNextInt()) {
                    System.out.println("OPÇÃO INVÁLIDA! DIGITE APENAS 1 ou 2 ");
                    scanner.nextLine();
                }
                int opcaoBusca = scanner.nextInt();

                if (opcaoBusca == 1) {
                    System.out.println("Digite o Código: ");
                    scanner.nextLine();
                    String codigoBusca = scanner.nextLine();
                    boolean encontrou = false;


                    for (int i = 0; i < posicao; i++) {
                        if (codigoBusca.equals(livros[i].codigoLivro)) {
                            encontrou = true;
                            System.out.println(" ------ LIVRO ENCONTRADO ------ ");
                            exibirLivro(livros[i]);
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println(" ------ LIVRO NÃO ENCONTRADO ------ ");
                    }
                } else if (opcaoBusca == 2) {
                    System.out.println("Digite o nome: ");
                    scanner.nextLine();
                    String nomeBusca = scanner.nextLine();
                    boolean encontrou = false;

                    for (int i = 0; i < posicao; i++) {
                        if (nomeBusca.equals(livros[i].nomeLivro)) {
                            encontrou = true;
                            System.out.println(" ------ LIVRO ENCONTRADO ------ ");
                            exibirLivro(livros[i]);
                            break;
                        }

                    }
                    if (!encontrou) {
                        System.out.println(" ------ LIVRO NÃO ENCONTRADO ------ ");
                    }
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

        System.out.println("\nNome do livro: " + livro.nomeLivro);
        System.out.println("Autor do livro: " + livro.nomeAutor);
        System.out.println("Código do livro: " + livro.codigoLivro);
        System.out.println("Gênero do livro: " + livro.generoLivro);
    }

    static String lerTextoObrigatorio(Scanner scanner, String pedido, String erro ){
        System.out.println(pedido);
        String texto = scanner.nextLine();
        while (texto.isEmpty()){
            System.out.println(erro);
            texto = scanner.nextLine();
        }
        return texto;
    }
}

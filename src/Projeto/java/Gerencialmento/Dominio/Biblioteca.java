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
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = scanner.nextLine();
                    livros[posicao].nomeLivro = nomeLivro.trim();
                    System.out.println("Livro cadastrado: " + nomeLivro);

                    System.out.println("\nDigite o nome do Autor: ");
                    String nomeAutor = scanner.nextLine();
                    livros[posicao].nomeAutor = nomeAutor.trim();
                    System.out.println("Autor cadastrado: " + nomeAutor);

                    System.out.println("\nDigite o código do livro: ");
                    String codigoLivro = scanner.nextLine();
                    livros[posicao].codigoLivro = codigoLivro;
                    System.out.println("Código cadastrado: " + codigoLivro);

                    System.out.println("\nDigite o gênero do livro: ");
                    String generoLivro = scanner.nextLine();
                    livros[posicao].generoLivro = generoLivro;
                    System.out.println("Gênero cadastrado: " + generoLivro);

                    System.out.println("Cadastro de livro ");

                    posicao++;

                }else{
                    System.out.println("Não é possível cadastrar mais livros. Limite atingido. ");
                }

            } else if (opcao == 2) {
                for (int i = 0; i < posicao; i++) {
                    System.out.println("\nNome do livro: " + livros[i].nomeLivro);
                    System.out.println("Autor do livro: " + livros[i].nomeAutor);
                    System.out.println("Código do livro: " + livros[i].codigoLivro);
                    System.out.println("Gênero do livro: " + livros[i].generoLivro);
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
                            System.out.println("\nNome do livro: " + livros[i].nomeLivro);
                            System.out.println("Autor do livro: " + livros[i].nomeAutor);
                            System.out.println("Código do livro: " + livros[i].codigoLivro);
                            System.out.println("Gênero do livro: " + livros[i].generoLivro);
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
                            System.out.println("\nNome do livro: " + livros[i].nomeLivro);
                            System.out.println("Autor do livro: " + livros[i].nomeAutor);
                            System.out.println("Código do livro: " + livros[i].codigoLivro);
                            System.out.println("Gênero do livro: " + livros[i].generoLivro);
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
}
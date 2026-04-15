package org.pcstore.view;

import org.pcstore.dao.CategoriaDAO;
import org.pcstore.dao.FornecedorDAO;
import org.pcstore.dao.ProdutoDAO;

import java.util.Scanner;

public class Menu {
    private ProdutoDAO produtoDAO;
    private FornecedorDAO fornecedorDAO;
    private CategoriaDAO categoriaDAO;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {}

    public Menu(ProdutoDAO produtoDAO, FornecedorDAO fornecedorDAO, CategoriaDAO categoriaDAO) {
        this.produtoDAO = produtoDAO;
        this.fornecedorDAO = fornecedorDAO;
        this.categoriaDAO = categoriaDAO;
    }

    public void menu() {
        String opcao;

        do {
            System.out.println(" ");
            System.out.println("[A] Sessão de Produtos");
            System.out.println("[B] Sessão de Fornecedores");
            System.out.println("[C] Sessão de Categorias");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    menuProdutos();
                    break;
                case "B":
                    menuFornecedores();
                    break;
                case "C":
                    menuCategorias();
                    break;
                case "F":
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("F"));
    }

    public void menuProdutos() {
        String opcao;

        do {
            System.out.println(" ");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    System.out.println(" ");
                    System.out.println("Cadastro de produto");
                    break;
                case "B":
                    System.out.println(" ");
                    System.out.println("Alteração de produto");
                    break;
                case "C":
                    System.out.println(" ");
                    System.out.println("Exclusão de produto");
                    break;
                case "F":
                    System.out.println(" ");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("F"));
    }

    public void menuFornecedores() {
        String opcao;

        do {
            System.out.println(" ");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    System.out.println(" ");
                    System.out.println("Cadastro de fornecedor");
                    break;
                case "B":
                    System.out.println(" ");
                    System.out.println("Alteração de fornecedor");
                    break;
                case "C":
                    System.out.println(" ");
                    System.out.println("Exclusão de fornecedor");
                    break;
                case "F":
                    System.out.println(" ");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("F"));
    }

    public void menuCategorias() {
        String opcao;

        do {
            System.out.println(" ");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    System.out.println(" ");
                    System.out.println("Cadastro de categoria");
                    break;
                case "B":
                    System.out.println(" ");
                    System.out.println("Alteração de categoria");
                    break;
                case "C":
                    System.out.println(" ");
                    System.out.println("Exclusão de categoria");
                    break;
                case "F":
                    System.out.println(" ");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("F"));
    }
}

package org.pcstore.view;

import org.pcstore.dao.CategoriaDAO;
import org.pcstore.dao.FornecedorDAO;
import org.pcstore.dao.ProdutoDAO;
import org.pcstore.model.Categoria;
import org.pcstore.service.CategoriaService;
import org.pcstore.service.FornecedorService;
import org.pcstore.service.ProdutoService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ProdutoService produtoService;
    private FornecedorService fornecedorService;
    private CategoriaService categoriaService;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        this.produtoService = new ProdutoService();
        this.fornecedorService = new FornecedorService();
        this.categoriaService = new CategoriaService();
    }


    public void menu() {
        String opcao;

        do {
            System.out.println(" ");
            System.out.println("[A] Sessão de Produtos");
            System.out.println("[B] Sessão de Fornecedores");
            System.out.println("[C] Sessão de Categorias");
            System.out.println("[D] Adicionar ao Estoque");
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
                case "D":
                    menuEstoque();
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
            System.out.println("Produto");
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
            System.out.println("Fornecedor");
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
        String opcao, resposta;
        CategoriaDAO cDAO = new CategoriaDAO();
        do {
            System.out.println(" ");
            System.out.println("Categoria");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[D] Listar");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    System.out.println(" ");
                    System.out.println("Cadastro de categoria");
                    System.out.print("Digite o nome da categoria que deseja cadastrar: ");
                    resposta = scanner.nextLine();
                    boolean cadastrou = categoriaService.cadastrarCategoria(resposta);
                    System.out.println(" ");
                    if(cadastrou) {
                        System.out.println("Categoria cadastrada com sucesso");
                    } else {
                        System.out.println("Categoria existente");
                    }
                    break;
                case "B":
                    Categoria categoriaAntiga = new Categoria();
                    Categoria categoriaNova = new Categoria();
                    System.out.println(" ");
                    System.out.println("Alteração de categoria");
                    System.out.print("Digite o id da categoria que deseja alterar: ");
                    System.out.println(" ");
                    resposta = scanner.nextLine();
                    categoriaAntiga = cDAO.buscar(Integer.parseInt(resposta));
                    if(categoriaAntiga != null) {
                        System.out.println(" ");
                        System.out.println("Informações da categoria: ");
                        System.out.println("Id: " + categoriaAntiga.getId() + " Nome: " + categoriaAntiga.getNome());
                        System.out.print("Digite o novo nome: ");
                        resposta = scanner.nextLine();
                        categoriaNova.setNome(resposta);
                        categoriaService.alterarCategoria(categoriaAntiga.getId(), categoriaNova);
                        System.out.println("Categoria alterada com sucesso");
                    } else {
                        System.out.println(" ");
                        System.out.println("Categoria não encontrada");
                    }
                    break;
                case "C":
                    Categoria categoria = new Categoria();

                    System.out.println(" ");
                    System.out.println("Exclusão de categoria");
                    System.out.print("Digite o id da categoria que deseja excluir: ");
                    System.out.println(" ");
                    resposta = scanner.nextLine();
                    categoria = cDAO.buscar(Integer.parseInt(resposta));
                    if(categoria != null) {
                        System.out.println(" ");
                        System.out.println("Informações da categoria: ");
                        System.out.println("Id: " + categoria.getId() + " Nome: " + categoria.getNome());
                        System.out.println("Confirmar exclusão? (S/N)");
                        resposta = scanner.nextLine();
                        System.out.println(" ");
                        if(resposta.equalsIgnoreCase("s")) {
                            categoriaService.excluirCategoria(categoria.getId());
                            System.out.println("Categoria excluída com sucesso");
                        } else if (resposta.equalsIgnoreCase("n")) {
                            System.out.println("Exclusão cancelada com sucesso");
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Categoria não encontrada");
                    }
                    break;
                case "D":
                    List<Categoria> categoriaList = new ArrayList<>();
                    System.out.println(" ");
                    System.out.println("Listar categorias");
                    categoriaList = cDAO.listar();
                    for(Categoria c : categoriaList) {
                        System.out.println("Id: " + c.getId() + " Nome: " + c.getNome() + " ,");
                    }
                    System.out.println(" ");
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
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

    public void menuEstoque() {

    }


}

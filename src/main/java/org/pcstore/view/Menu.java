package org.pcstore.view;

import org.pcstore.dao.CategoriaDAO;
import org.pcstore.dao.FornecedorDAO;
import org.pcstore.dao.ProdutoDAO;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;
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
        String opcao, resposta;
        List<String> respostas = new ArrayList<>();
        ProdutoDAO pDAO = new ProdutoDAO();
        FornecedorDAO fDAO = new FornecedorDAO();
        CategoriaDAO cDAO = new CategoriaDAO();

        do {
            respostas = new ArrayList<>();
            System.out.println(" ");
            System.out.println("Produto");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[D] Listar");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    Produto novoProduto = new Produto();
                    Categoria categoria = new Categoria();
                    Fornecedor fornecedor = new Fornecedor();

                    System.out.println(" ");
                    System.out.println("Cadastro de produto");

                    System.out.print("Digite o nome do produto que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());

                    System.out.print("Digite a marca do produto que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());

                    System.out.print("Digite o id da categoria do produto que deseja cadastrar: ");
                    resposta = scanner.nextLine();
                    categoria = cDAO.buscar(Integer.parseInt(resposta));

                    if(categoria != null) {
                        System.out.print("Digite o preço do produto que deseja cadastrar: ");
                        respostas.add(resposta = scanner.nextLine());

                        System.out.print("Digite a quantidade de estoque do produto que deseja cadastrar: ");
                        respostas.add(resposta = scanner.nextLine());

                        System.out.print("Digite o id do fornecedor do produto que deseja cadastrar: ");
                        resposta = scanner.nextLine();
                        fornecedor = fDAO.buscar(Integer.parseInt(resposta));

                        if(fornecedor != null) {
                            novoProduto.setNome(respostas.get(0));
                            novoProduto.setMarca(respostas.get(1));
                            novoProduto.setCategoria(categoria);
                            novoProduto.setPreco(Double.parseDouble(respostas.get(2)));
                            novoProduto.setQuantidade_estoque(Integer.parseInt(respostas.get(3)));
                            novoProduto.setFornecedor(fornecedor);

                            boolean cadastrou = produtoService.cadastrarProduto(novoProduto);

                            System.out.println(" ");
                            if(cadastrou) {
                                System.out.println("Produto cadastrado com sucesso");
                            } else {
                                System.out.println("Produto existente");
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("Fornecedor não encontrado");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Categoria não encontrada");
                    }
                    break;

                case "B":
                    Produto produtoAntigo = new Produto();
                    Produto produtoNovo = new Produto();
                    Categoria categoriaNova = new Categoria();
                    Fornecedor fornecedorNovo = new Fornecedor();

                    System.out.println(" ");
                    System.out.println("Alteração de produto");
                    System.out.print("Digite o id do produto que deseja alterar: ");
                    resposta = scanner.nextLine();

                    produtoAntigo = pDAO.buscar(Integer.parseInt(resposta));

                    if(produtoAntigo != null) {
                        System.out.println(" ");
                        System.out.println("Informações do produto: ");
                        mostrarProduto(produtoAntigo);

                        System.out.print("Digite o novo nome: ");
                        respostas.add(resposta = scanner.nextLine());

                        System.out.print("Digite a nova marca: ");
                        respostas.add(resposta = scanner.nextLine());

                        System.out.print("Digite o novo id da categoria: ");
                        resposta = scanner.nextLine();
                        categoriaNova = cDAO.buscar(Integer.parseInt(resposta));

                        if(categoriaNova != null) {
                            System.out.print("Digite o novo preço: ");
                            respostas.add(resposta = scanner.nextLine());

                            System.out.print("Digite a nova quantidade de estoque: ");
                            respostas.add(resposta = scanner.nextLine());

                            System.out.print("Digite o novo id do fornecedor: ");
                            resposta = scanner.nextLine();
                            fornecedorNovo = fDAO.buscar(Integer.parseInt(resposta));

                            if(fornecedorNovo != null) {
                                produtoNovo.setNome(respostas.get(0));
                                produtoNovo.setMarca(respostas.get(1));
                                produtoNovo.setCategoria(categoriaNova);
                                produtoNovo.setPreco(Double.parseDouble(respostas.get(2)));
                                produtoNovo.setQuantidade_estoque(Integer.parseInt(respostas.get(3)));
                                produtoNovo.setFornecedor(fornecedorNovo);

                                produtoService.alterarProduto(produtoAntigo.getId(), produtoNovo);
                                System.out.println("Produto alterado com sucesso");
                            } else {
                                System.out.println(" ");
                                System.out.println("Fornecedor não encontrado");
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("Categoria não encontrada");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case "C":
                    Produto produto = new Produto();

                    System.out.println(" ");
                    System.out.println("Exclusão de produto");
                    System.out.print("Digite o id do produto que deseja excluir: ");
                    resposta = scanner.nextLine();

                    produto = pDAO.buscar(Integer.parseInt(resposta));

                    if(produto != null) {
                        System.out.println(" ");
                        System.out.println("Informações do produto: ");
                        mostrarProduto(produto);

                        System.out.println("Confirmar exclusão? (S/N)");
                        resposta = scanner.nextLine();
                        System.out.println(" ");

                        if(resposta.equalsIgnoreCase("s")) {
                            produtoService.excluirProduto(produto.getId());
                            System.out.println("Produto excluído com sucesso");
                        } else if (resposta.equalsIgnoreCase("n")) {
                            System.out.println("Exclusão cancelada com sucesso");
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case "D":
                    List<Produto> produtoList = new ArrayList<>();
                    System.out.println(" ");
                    System.out.println("Listar produtos");

                    produtoList = produtoService.listarProdutos();

                    for(Produto p : produtoList) {
                        mostrarProduto(p);
                        System.out.println("------------------------------");
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

    private void mostrarProduto(Produto produto) {
        System.out.println("Id: " + produto.getId() + " Nome: " + produto.getNome());
        System.out.println("Marca: " + produto.getMarca() + " Preço: R$ " + produto.getPreco());
        System.out.println("Estoque: " + produto.getQuantidade_estoque());

        if(produto.getCategoria() != null) {
            System.out.println("Categoria: " + produto.getCategoria().getId() + " - " + produto.getCategoria().getNome());
        }

        if(produto.getFornecedor() != null) {
            System.out.println("Fornecedor: " + produto.getFornecedor().getId() + " - " + produto.getFornecedor().getNome());
        }
    }

    public void menuFornecedores() {
        String opcao, resposta;
        List<String> respostas = new ArrayList<>();
        Fornecedor novoFornecedor = new Fornecedor();
        FornecedorDAO fDAO = new FornecedorDAO();
        do {
            respostas = new ArrayList<>();
            System.out.println(" ");
            System.out.println("Fornecedor");
            System.out.println("[A] Cadastro");
            System.out.println("[B] Alteração");
            System.out.println("[C] Exclusão");
            System.out.println("[D] Listar");
            System.out.println("[F] Sair");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "A":
                    System.out.println(" ");
                    System.out.println("Cadastro de fornecedor");
                    System.out.print("Digite o nome do fornecedor que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());
                    System.out.print("Digite o CNPJ do fornecedor que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());
                    System.out.print("Digite o telefone do fornecedor que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());
                    System.out.print("Digite o e-mail do forneceddor que deseja cadastrar: ");
                    respostas.add(resposta = scanner.nextLine());
                    novoFornecedor.setNome(respostas.get(0));
                    novoFornecedor.setCnpj(respostas.get(1));
                    novoFornecedor.setTelefone(respostas.get(2));
                    novoFornecedor.setEmail(respostas.get(3));
                    boolean cadastrou = fornecedorService.cadastrarFornecedor(novoFornecedor);
                    System.out.println(" ");
                    if(cadastrou) {
                        System.out.println("Fornecedor cadastrado com sucesso");
                    } else {
                        System.out.println("Fornecedor existente");
                    }
                    break;
                case "B":
                    Fornecedor fornecedorAntigo = new Fornecedor();
                    Fornecedor fornecedorNovo = new Fornecedor();
                    System.out.println(" ");
                    System.out.println("Alteração de fornecedor");
                    System.out.print("Digite o id do fornecedor que deseja alterar: ");
                    System.out.println(" ");
                    resposta = scanner.nextLine();
                    fornecedorAntigo = fDAO.buscar(Integer.parseInt(resposta));
                    if(fornecedorAntigo != null) {
                        System.out.println(" ");
                        System.out.println("Informações do fornecedor: ");
                        System.out.println("Id: " + fornecedorAntigo.getId() + " Nome: " + fornecedorAntigo.getNome());
                        System.out.println("CNPJ: " + fornecedorAntigo.getCnpj() + " Telefone: " + fornecedorAntigo.getTelefone() + " Email: " + fornecedorAntigo.getEmail());
                        System.out.print("Digite o novo nome: ");
                        respostas.add(resposta = scanner.nextLine());
                        System.out.print("Digite o novo CNPJ: ");
                        respostas.add(resposta = scanner.nextLine());
                        System.out.print("Digite o novo telefone: ");
                        respostas.add(resposta = scanner.nextLine());
                        System.out.print("Digite o novo email: ");
                        respostas.add(resposta = scanner.nextLine());
                        fornecedorNovo.setNome(respostas.get(0));
                        fornecedorNovo.setCnpj(respostas.get(1));
                        fornecedorNovo.setTelefone(respostas.get(2));
                        fornecedorNovo.setEmail(respostas.get(3));
                        fornecedorService.alterarFornecedor(fornecedorAntigo.getId(), fornecedorNovo);
                        System.out.println("Fornecedor alterado com sucesso");
                    } else {
                        System.out.println(" ");
                        System.out.println("Fornecedor não encontrado");
                    }
                    break;
                case "C":
                    Fornecedor fornecedor = new Fornecedor();
                    System.out.println(" ");
                    System.out.println("Exclusão de fornecedor");
                    System.out.print("Digite o id do fornecedor que deseja excluir: ");
                    System.out.println(" ");
                    resposta = scanner.nextLine();
                    fornecedor = fDAO.buscar(Integer.parseInt(resposta));
                    if(fornecedor != null) {
                        System.out.println(" ");
                        System.out.println("Informações do fornecedor: ");
                        System.out.println("Id: " + fornecedor.getId() + " Nome: " + fornecedor.getNome());
                        System.out.println("CNPJ: " + fornecedor.getCnpj() + " Telefone: " + fornecedor.getTelefone() + " Email: " + fornecedor.getEmail());
                        System.out.println("Confirmar exclusão? (S/N)");
                        resposta = scanner.nextLine();
                        System.out.println(" ");
                        if(resposta.equalsIgnoreCase("s")) {
                            fornecedorService.excluirFornecedor(fornecedor.getId());
                            System.out.println("Fornecedor excluído com sucesso");
                        } else if (resposta.equalsIgnoreCase("n")) {
                            System.out.println("Exclusão cancelada com sucesso");
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Fornecedor não encontrado");
                    }
                    break;
                case "D":
                    List<Fornecedor> fornecedorList = new ArrayList<>();
                    System.out.println(" ");
                    System.out.println("Listar fornecedor");
                    fornecedorList = fDAO.listar();
                    for(Fornecedor f : fornecedorList) {
                        System.out.println("Id: " + f.getId() + " Nome: " + f.getNome());
                        System.out.println("CNPJ: " + f.getCnpj() + " Telefone: " + f.getTelefone() + " Email: " + f.getEmail());
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

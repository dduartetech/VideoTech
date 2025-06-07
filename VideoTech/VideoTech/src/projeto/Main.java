package projeto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU VIDEOTECH =====");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Emprestar filme");
            System.out.println("4. Devolver filme");
            System.out.println("5. Ver filmes emprestados");
            System.out.println("6. Ver filmes disponíveis");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Tipo \n1 = Físico \n2 = Digital \n: ");
                        int tipo = scanner.nextInt(); scanner.nextLine();
                        Filme filme;
                        if (tipo == 1) {
                            filme = new FilmeFisico();
                            System.out.print("Minutos: ");
                            ((FilmeFisico) filme).setDuracaoMinutos(scanner.nextInt()); 
                            scanner.nextLine();
                        } else if (tipo == 2){
                            filme = new FilmeDigital();
                            System.out.print("Tamanho em GB: ");
                            ((FilmeDigital) filme).setTamanhoGB(scanner.nextDouble()); 
                            scanner.nextLine();
                          } else {
                        	  System.out.println("Opção inválida!");
                        	  break;
                          }
                        System.out.print("Título: "); 
                        filme.setTitulo(scanner.nextLine());
                        System.out.print("Diretor: "); 
                        filme.setDiretor(scanner.nextLine());
                        locadora.cadastrarFilme(filme);
                        System.out.println("Filme cadastrado!");
                    }
                    case 2 -> {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Tipo \n1 = Usuario \n2 = Usuario Premium \n: ");
                        int tipo = scanner.nextInt(); 
                        scanner.nextLine();
                        Usuario usuario;
                        if (tipo == 1) {
                            usuario = new UsuarioFree(nome, id);  
                        } else if (tipo == 2) {
                            usuario = new UsuarioPlus(nome, id);  
                        } else {
                            System.out.println("Opção inválida!");
                            break;  
                        }
                        
                        locadora.cadastrarUsuario(usuario);
                        System.out.println("Usuário cadastrado!");
                    }
                    case 3 -> {
                        System.out.print("ID do usuário: ");
                        String id = scanner.nextLine();
                        List <Usuario> usuarios = locadora.buscarUsuario(id);
                        if (usuarios == null) {
                            System.out.println("Usuário não encontrado.");
                            break;
                        }
                        System.out.print("Título do filme: ");
                        String titulo = scanner.nextLine();
                        List<Filme> encontrados = locadora.buscarFilme(titulo);
                        if (encontrados.isEmpty()) {
                            System.out.println("Filme não encontrado.");
                        } else {
                            Filme filme = encontrados.get(0);
                            usuarios.get(0).emprestarFilme(filme);
                            System.out.println("Livro emprestado ao usuário!");
                        }
                    }
                    case 4 -> {
                        System.out.print("ID do usuário: ");
                        String id = scanner.nextLine();
                        List <Usuario> usuario = locadora.buscarUsuario(id);
                        if (usuario == null) {
                            System.out.println("Usuário não encontrado.");
                            break;
                        }
                        System.out.print("Título do filme: ");
                        String titulo = scanner.nextLine();
                        List<Filme> encontrados = locadora.buscarFilme(titulo);
                        if (encontrados.isEmpty()) {
                            System.out.println("Filme não encontrado.");
                        } else {
                            Filme filme = encontrados.get(0);
                            usuario.get(0).devolverFilme(filme);
                            System.out.println("Filme devolvido com sucesso!");
                        }
                    }
                    case 5 -> {
                        for (Filme filme : locadora.filmesEmprestados()) {
                            System.out.println(filme);
                        }
                    }
                    case 6 -> {
                        for (Filme filme : locadora.filmesDisponiveis()) {
                            System.out.println(filme);
                        }
                    }
                    case 7 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 7);
        scanner.close();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int escolhaMenu = 0;
        boolean existe;
        String resposta;
        String nome = "";
        do {
            System.out.println("1 - Cadastrar nome");
            System.out.println("2 - Listar todos nomes");
            System.out.println("3 - Verificar se existe um nome");
            System.out.println("4 - Editar um nome");
            System.out.println("5 - Remover um nome");
            System.out.print("Digite a opção que deseja: ");

            boolean escolhaValida = false;
            do {
                try {
                    escolhaMenu = teclado.nextInt();
                    if (escolhaMenu >= 1 && escolhaMenu <= 5) {
                        escolhaValida = true;
                    } else {
                        System.out.print("Por favor, digite um número entre 1 e 5: ");
                    }
                } catch (Exception e) {
                    System.out.print("Por favor, digite um números entre 1 a 5 ");
                    teclado.next(); /* LIMPAR BUFFER */
                }
            } while(!escolhaValida);

            if (escolhaMenu == 1) {
                System.out.print("Digite um nome para adicionar à lista: ");
                nome = teclado.next();
                try{
                    if(nome.matches(".*\\d.*")||(nome.matches(".*[^a-zA-Z0-9 ].*"))){
                        System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    }else{
                        existe = false;
                        for(String n : nomes) {
                            if (n.equalsIgnoreCase(nome)) {
                                existe = true;
                                break;
                            }
                        }
                        if (existe == true) {
                            System.out.println("Já existe este nome em nossa lista");
                        } else {
                            nomes.add(nome);
                            System.out.println("Nome cadastrado com sucesso!");
                        }

                    }

                } catch (Exception e) {
                    System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    teclado.next();/*Limpar Buffer*/
                }

            } else if (escolhaMenu == 2) {
                existe = false;
                for (String n : nomes){
                    if (n.contains(nome)) {
                        existe = true;
                        break;
                    }
                }
                if (existe == true){
                    System.out.println("Lista de nomes");
                    System.out.println(nomes);
                }else{
                    System.out.println("Não há nenhum nome na lista");
                }

            } else if (escolhaMenu == 3) {
                System.out.println("Digite o nome que deseja verificar: ");
                nome = teclado.next();
                try{
                    if(nome.matches(".*\\d.*")||(nome.matches(".*[^a-zA-Z0-9 ].*"))){
                        System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    }else{
                        existe = false;
                        for (String n:nomes){
                            if (n.equalsIgnoreCase(nome)) {
                                existe = true;
                                break;
                            }
                        }
                        if (existe == true) {
                            System.out.println("Existe este nome na lista.");
                        }
                        else{
                            System.out.println("Nome não encontrado.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    teclado.next();/*Limpar Buffer*/
                }
            } else if (escolhaMenu == 4) {
                System.out.print("Escreva o nome que deseja editar: ");
                nome = teclado.next();
                try{
                    if(nome.matches(".*\\d.*")||(nome.matches(".*[^a-zA-Z0-9 ].*"))){
                        System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    }else{
                        existe = false;
                        for (String n:nomes){
                            if (n.equalsIgnoreCase(nome)){
                                existe = true;
                                break;
                            }
                        }
                        for (String lista : nomes) {
                            if (nomes.contains(nome)) {
                                nomes.remove(nome);
                                System.out.print("Escreva o novo nome: ");
                                nome = teclado.next();
                                try {
                                    if (nome.matches(".*\\d.*") || (nome.matches(".*[^a-zA-Z0-9 ].*"))) {
                                        System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                                    } else {
                                        existe = false;
                                        for (String n : nomes) {
                                            if (n.equalsIgnoreCase(nome)) {
                                                existe = true;
                                                break;
                                            }
                                        }
                                        if (existe == true) {
                                            System.out.println("Já existe este nome em nossa lista.");
                                        } else {
                                            nomes.add(nome);
                                            System.out.println("Nome cadastrado com sucesso");
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                                    teclado.next(); /*Limpar Buffer*/
                                }
                            }else{
                                System.out.println("Este nome não está cadastrado em nossa lista.");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    teclado.next();/*Limpar Buffer*/
                }

            } else if (escolhaMenu == 5) {
                System.out.print("Digite o nome que deseja remover: ");
                nome = teclado.next();
                try{
                    if(nome.matches(".*\\d.*")||(nome.matches(".*[^a-zA-Z0-9 ].*"))){
                        System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    }else{
                        existe = false;
                        for (String n:nomes){
                            if (n.equalsIgnoreCase(nome)){
                                existe = true;
                                break;
                            }
                        }
                        if(existe == true){
                            nomes.remove(nome);
                            System.out.println("O nome foi removido com sucesso");
                        }
                        else{
                            System.out.println("Esse nome não existe na lista");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, digite um nome sem números e/ou símbolos especiais.");
                    teclado.next();/*Limpar Buffer*/
                }

            }
            System.out.print("Deseja voltar para o menu? (Sim ou Não): ");
            resposta = teclado.next();
        }while(resposta.equalsIgnoreCase("Sim") || (resposta.equalsIgnoreCase("S")));
    }
}
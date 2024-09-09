import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<String> minhaLista = new ArrayList<>();
        List<String> meusnumeros = new ArrayList<>();

        // Abre o menu
        // Também verifica se a entrada é o comando pedido

        String r = " ";
        System.out.println("Para ver o menu digite 1");
        while (!r.equals("1")) {
            r = teclado.nextLine();
            if (!r.equals("1")) {
                System.out.println("Digite uma entrada válida, por favor");
                r = teclado.nextLine();
            } else {
                break;
            }
        }


        // Menu

        String r2 = " ";
        while (!r.equals("4")) {
            System.out.println("Escolha\n" +
                    "1 para adicionar uma tarefa\n" +
                    "2 para marcar uma tarefa como concluída\n" +
                    "3 para ver a lista de tarefas\n" +
                    "4 para encerrar o programa");
            r2 = teclado.nextLine();
            if (r2.equals("4")){
                break;
            }
            while (!r2.equals("1") && !r2.equals("2") && !r2.equals("3") && r2.equals("4")) {
                if (!r2.equals("1") && !r2.equals("2") && !r2.equals("3") && r2.equals("4")) {
                    System.out.println("Digite uma entrada válida, por favor");
                    teclado.nextLine();
                } else {
                    r2 = teclado.nextLine();
                    teclado.nextLine();
                }
            }


            // Verifica se a tarefa existe e não permite adicionar a mesma tarefa
            // Se a tarefa não existir, adiciona a tarefa
            // No meio há uma validação para uma resposta válida
            String r3 = " ";
            boolean tarefaexiste = false;
            if (r2.equals("1")) {
                System.out.println("Diga a tarefa a ser adicionada: ");
                String user = teclado.nextLine().trim();
                while (user.isEmpty() || user.matches("\\d+")) {
                    System.out.println("A tarefa não pode ser um espaço em branco ou número");
                    user = teclado.nextLine().trim();
                    for (String tarefa : minhaLista) {
                        if (tarefa.equalsIgnoreCase(user)) {
                            tarefaexiste = true;
                        }
                    }
                }
                for (String tarefa : minhaLista) {
                    if (tarefa.equalsIgnoreCase(user)) {
                        tarefaexiste = true;
                    }
                }
                if (tarefaexiste) {
                    System.out.println("Essa tarefa já está na adicionada na lista");
                    System.out.println("Digite 1 para voltar ao menu ou 2 para encerrar o programa");
                    while (!r3.equals("1") && !r3.equals("2")) {
                        if (!teclado.hasNextInt()) {
                            System.out.println("Digite uma entrada válida, por favor");
                            teclado.nextLine();
                        } else {
                            r3 = teclado.nextLine();
                            teclado.nextLine();
                            if (!r3.equals("1") && !r3.equals("2")) {
                                System.out.println("Digite uma entrada válida, por favor");
                            }
                        }
                    }
                    if (r3.equals("2")) {
                        break;
                    }
                } else {
                    minhaLista.add(user);
                    int num = 1;
                    for (String numero : minhaLista) {
                        num = +1;
                        meusnumeros.add(String.valueOf(num));}
                    System.out.println("Tarefa adicionada com sucesso");
                }

                r2 = " ";


                // Escolhe uma tarefa dentro da lista para ser marcada como concluída
                // Ao escolher uma tarefa, remove ela da lista

            } else if (r2.equals("2")) {
                System.out.println("Escolha a tarefa a ser marcada como concluída, " +
                        "ou digite 'voltar' para retornar ao menu");
                System.out.println("Suas Tarefas:");
                int n1 = 1;
                for (String elemento : minhaLista){
                    System.out.println(n1 + " - " + elemento);
                    n1 = n1 + 1;
                }
                String r4 = teclado.nextLine();
                tarefaexiste = false;
                while (!tarefaexiste) {
                    if(r4.matches("\\d+")){
                        for (String numero : meusnumeros) {
                            int num1 = Integer.valueOf(r4);
                            if (num1 >= 0 && num1 <= minhaLista.size()) {
                                tarefaexiste = true;
                                minhaLista.remove(num1 - 1);
                                System.out.println("Tarefa concluída");
                                break;
                            }
                            break;
                        }
                    }
                    if (!tarefaexiste) {
                        if (r4.equalsIgnoreCase("voltar")) {
                            tarefaexiste = true;
                            System.out.println("Voltando ao menu");
                            break;
                        } else {
                            System.out.println("Digite uma entrada válida ou escreva 'voltar' " +
                                    "para retornar ao menu");
                            int n2 = 1;
                            for (String elemento : minhaLista){
                                System.out.println(n2 + " - " + elemento);
                                n2 = n2 + 1;}
                            r4 = teclado.nextLine();
                        }
                    }
                }

                r2 = " ";

                // Mostra a lista de tarefas

            } else if (r2.equals("3")) {
                System.out.println("Essas são suas tarefas: ");
                int n3 = 1;
                for (String elemento : minhaLista){
                    System.out.println(n3 + " - " + elemento);
                    n3 = n3 + 1;}
                System.out.println("Digite 1 para voltar ao menu, ou 2 para encerrar o programa");
                while (!r3.equals("1") && !r3.equals("2")) {
                    if (!teclado.hasNextInt()) {
                        System.out.println("Digite uma entrada válida, por favor");
                        teclado.nextLine();
                    } else {
                        r3 = teclado.nextLine();
                    }
                }
                if (r3.equals("2")){
                    break;
                }
            }
        }
        System.out.println("Programa encerrado");
    }
}

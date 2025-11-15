package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.API.Api;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        Menu menu = new Menu();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.print("Digite um filme para busca: ");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            menu.setResponse(Api.chamarApi(busca));
            menu.menu();
        }

        System.out.println(menu.getTitulos());

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(menu.gson.toJson(menu.getTitulos()));
        escrita.close();
        System.out.println("Finalizou corretamente!");

    }
}
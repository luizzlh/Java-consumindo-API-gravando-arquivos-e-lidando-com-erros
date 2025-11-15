package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.API.Api;
import br.com.alura.screenmatch.API.ConversaoGson;
import br.com.alura.screenmatch.exceptions.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    HttpResponse<String> response;
    Gson gson = ConversaoGson.criarGson();
    List<Titulo> titulos = new ArrayList<>();

    public Menu(){}

    public void menu(){
        try{

            String json = response.body();
            System.out.println(json);

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);


            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);

            titulos.add(meuTitulo);

        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Verifique o endereço de busca!");
            System.out.println(e.getMessage());
        } catch (
                ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }

    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public Gson getGson() {
        return gson;
    }

    public void setResponse(HttpResponse<String> response) {
        this.response = response;
    }
}

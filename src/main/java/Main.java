import br.com.florinda.cardapio.ItemCardapio;
import com.google.gson.Gson;

import java.math.BigDecimal;

import static br.com.florinda.cardapio.ItemCardapio.CategoriaCardapio.BEBIDAS;

public class Main {

    public static void main(String[] args) {

        ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves", "Suco de Limão", BEBIDAS,
                new BigDecimal("2.99"), null);

        Gson gson = new Gson();
        String json = gson.toJson(refrescoDoChaves);
        System.out.printf(json);


    }
}

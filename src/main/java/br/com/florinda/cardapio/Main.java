package br.com.florinda.cardapio;

import java.util.*;

import static br.com.florinda.cardapio.ItemCardapio.CategoriaCardapio.*;

public class Main {

    public static void main(String[] args) {

        Database database = new Database();
        List<ItemCardapio> itens = database.listaDeItemCardapio();

        Optional<ItemCardapio> optionalItem = database.itemCardapioPorId(121L);
        String mensagem = optionalItem
                .map(ItemCardapio::toString)
                .orElse("Não Encontrado");
        System.out.println(mensagem);


        //PRECISA MANTER AS CATEGORIAS QUE ESTÃO EM PROMOÇÃO
        Set<ItemCardapio.CategoriaCardapio> categoriaCardapios = EnumSet.of(SOBREMESA, ENTRADA);
        categoriaCardapios.add(PRATOS_PRINCIPAIS);
        categoriaCardapios.forEach(System.out::println);

        //PRECISO DAS DESCRICOES ASSOCIADAS AS CATEGORIAS EM PRODUCAO

        Map<ItemCardapio.CategoriaCardapio, String> promocoes = new EnumMap<>(ItemCardapio.CategoriaCardapio.class);
        promocoes.put(SOBREMESA, "O doce perfito para você!" );
        promocoes.put(ENTRADA, " Comece sua refeição com um toque de sabor!" );
        System.out.println(promocoes);

        System.out.println("============================");

        // PRECISO DE HISTORIO DE VISUALIZACAO DO CARDAPIO

        HistoricoVisualizacao historico = new HistoricoVisualizacao(database);
        historico.registrarVisualizacao(1L);
        historico.registrarVisualizacao(3L);
        historico.registrarVisualizacao(6L);
        historico.registrarVisualizacao(7L);

        historico.mostrarTotalItensVisualizados();
        historico.listarVisualizacoes();



    }
}

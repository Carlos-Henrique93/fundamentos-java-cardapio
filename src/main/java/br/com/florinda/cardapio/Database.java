package br.com.florinda.cardapio;

import java.math.BigDecimal;
import java.util.*;


import static br.com.florinda.cardapio.ItemCardapio.CategoriaCardapio.*;

public class Database {

    private final Map<Long, ItemCardapio> itensPorId = new HashMap<>();

    public Database(){
        ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves", "Suco de Limão", BEBIDAS,
                new BigDecimal("2.99"), null);
        itensPorId.put(1L,refrescoDoChaves);


        ItemCardapio sanduicheDoChaves = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves",
                "Sanduíche de presunto simples, mas feito com muito amor.",
                PRATOS_PRINCIPAIS, new BigDecimal("3.50"), new BigDecimal("2.99"));
        itensPorId.put(2L,sanduicheDoChaves);

        ItemCardapio tortaDaDonaFlorinda = new ItemCardapio(5L, "Torta de Frango da Dona Florinda",
                "Torta de frango com recheio cremoso e massa crocante.",
                PRATOS_PRINCIPAIS, new BigDecimal("12.99"), new BigDecimal("10.99"));
        itensPorId.put(5L,tortaDaDonaFlorinda);

        ItemCardapio pipocaDoQuico = new ItemCardapio(6L, "Pipoca do Quico",
                "Balde de pipoca preparado com carinho pelo Quico.",
                PRATOS_PRINCIPAIS, new BigDecimal("4.99"), new BigDecimal("3.99"));
        itensPorId.put(6L,pipocaDoQuico);

        ItemCardapio aguaDeJamaica = new ItemCardapio(7L, "Água de Jamaica",
                "Água aromatizada com hibisco e toque de açúcar.",
                BEBIDAS, new BigDecimal("2.50"), new BigDecimal("2.00"));
        itensPorId.put(7L,aguaDeJamaica);

        ItemCardapio churrosDoChaves = new ItemCardapio(9L, "Churros do Chaves",
                "Churros recheados com doce de leite, clássicos e irresistíveis.",
                SOBREMESA, new BigDecimal("4.99"), new BigDecimal("3.99"));
        itensPorId.put(9L,churrosDoChaves);


    }

    public List<ItemCardapio> listaDeItemCardapio (){

        return new ArrayList<>(itensPorId.values());
    }

    public Optional<ItemCardapio> itemCardapioPorId(Long itemId) {
        ItemCardapio itemCardapio = itensPorId.get(itemId);
        return  Optional.ofNullable(itemCardapio);

    }
}

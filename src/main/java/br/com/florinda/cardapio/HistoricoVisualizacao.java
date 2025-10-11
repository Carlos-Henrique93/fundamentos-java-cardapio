package br.com.florinda.cardapio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoricoVisualizacao {

    private final Database database;

    //ItemCardapio => Data e Hora

    private final Map<ItemCardapio, LocalDateTime> visualizacoes = new HashMap<>();

    public HistoricoVisualizacao (Database database){
        this.database = database;
    }

    public void registrarVisualizacao(Long itemID){
        Optional<ItemCardapio> optionalItemCardapio = database.itemCardapioPorId(itemID);
        if (optionalItemCardapio.isEmpty()){
            System.out.println("Item não encontrado: " + itemID);
            return;
        }

        ItemCardapio itemCardapio = optionalItemCardapio.get();
        LocalDateTime agora = LocalDateTime.now();
        visualizacoes.put(itemCardapio, agora);
        System.out.printf("'%s' visualizando em '%s'\n", itemCardapio.nome(),agora);

    }

    public void mostrarTotalItensVisualizados() {
        System.out.println("\nTotal de itens visualizados: " + visualizacoes.size());
    }

    public void listarVisualizacoes() {
        if (visualizacoes.isEmpty()){
            System.out.println("Nenhum item foi visualizado");
            return;
        }

        System.out.println("\nHistorico de Visualizacoes");
        visualizacoes.forEach((item, hora) ->
                System.out.printf("- %s em %s\n", item.nome(), hora));
        System.out.println();
    }
}

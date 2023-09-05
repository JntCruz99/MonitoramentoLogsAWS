import java.util.*;
import java.util.stream.Collectors;

public class MonitoramentoLogsAWS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Map<String, Long> eventosPorServico = new HashMap<>();
        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];

            // Utilize o mapa para registrar/incrementar o serviço em questão.
            eventosPorServico.put(servico, eventosPorServico.getOrDefault(servico, 0L) + 1);
        }

        // Identifique no mapa os serviços com maior e menor quantidade de logs.
        // Dica: Utilize Java Streams para tornar essa tarefa mais simples.
        Map.Entry<String, Long> servicoComMaiorQuantidade = eventosPorServico.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);

        Map.Entry<String, Long> servicoComMenorQuantidade = eventosPorServico.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);


        // Imprima a saída no padrão definido no enunciado deste desafio.
        System.out.println("Eventos por servico:");
        for (Map.Entry<String, Long> entry : eventosPorServico.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Maior:" + servicoComMaiorQuantidade.getKey() + " (" + servicoComMaiorQuantidade.getValue() + " logs)");
        System.out.println("Menor:" + servicoComMenorQuantidade.getKey() + " (" + servicoComMenorQuantidade.getValue() + " logs)");
    }
}

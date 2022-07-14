import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        List<Map<String, String>> original = new ArrayList<>();
        original.add(Map.of("nome", "João", "nascimento", "1985-12-11 12:10:33"));
        original.add(Map.of("nome", "Maria", "nascimento", "24-07-1988 23:02:41"));
        original.add(Map.of("nome", "Ana", "nascimento", "03:58:26 14-02-1983"));
        original.add(Map.of("nome", "Pedro", "nascimento", "08:03:07 1989-11-02"));

        System.out.println("acessando a lista original " + original.get(0).toString());

    }

    public static List<Map<String, String>> formatarData(List<Map<String, String>> original) {

        List<Map<String, String>> formatada = new ArrayList<>();
        DateTimeFormatter padraoFinal = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DateTimeFormatter tipo1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter tipo2 = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        DateTimeFormatter tipo3 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter tipo4 = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");

        for (Map<String, String> dado : original) {
            String nome = dado.get("nome");
            String data = dado.get("nascimento");

            if (data.matches("^[0-9]{4}.+[0-9]{2}$")) {
                formatada.add(Map.of("nome", nome, "nascimento", padraoFinal.format(LocalDateTime.parse(data, tipo1))));
            }

            if (data.matches("^?.+[0-9]{4}$")) {
                formatada.add(Map.of("nome", nome, "nascimento", padraoFinal.format(LocalDateTime.parse(data, tipo2))));
            }
            if (data.matches("^\\d{2}-\\d{2}-\\d{4}.+?$")) {
                formatada.add(Map.of("nome", nome, "nascimento", padraoFinal.format(LocalDateTime.parse(data, tipo3))));
            }
            if (data.matches("^?.+\\d{4}-\\d{2}-\\d{2}")) {
                formatada.add(Map.of("nome", nome, "nascimento", padraoFinal.format(LocalDateTime.parse(data, tipo4))));

            }

        }
        return formatada;
    }
}

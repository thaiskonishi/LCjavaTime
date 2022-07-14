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

        DateTimeFormatter formatoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Map<String, String>> formatada = formatarData(original, formatoPadrao);

        // System.out.println("acessando a lista original " +
        // original.get(0).toString());

        System.out.println("Lista original");
        for (Map<String, String> dado : original) {
            System.out.println(dado);
        }

        System.out.println("Lista formatada");
        for (Map<String, String> dado : formatada) {
            System.out.println(dado);
        }

        System.out.println("Pessoa mais nova é: " + maisNovo(formatada).toString());
        System.out.println("Pessoa mais velha é: " + maisVelho(formatada).toString());
    }

    public static List<Map<String, String>> formatarData(List<Map<String, String>> original,
            DateTimeFormatter padraoFinal) {

        List<Map<String, String>> formatada = new ArrayList<>();

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

    public static Map<String, String> maisVelho(List<Map<String, String>> listaDatasFormatadas) {

        DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Map<String, String> retornaMaisVelho;
        LocalDateTime data1, data2;

        retornaMaisVelho = listaDatasFormatadas.get(0);

        for (Map<String, String> dado : listaDatasFormatadas) {

            data1 = LocalDateTime.parse(retornaMaisVelho.get("nascimento"), padrao);
            data2 = LocalDateTime.parse(dado.get("nascimento"), padrao);

            if (data1.isAfter(data2)) {
                retornaMaisVelho = dado;
            }

        }
        return retornaMaisVelho;
    }

    public static Map<String, String> maisNovo(List<Map<String, String>> listaDatasFormatadas) {

        DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Map<String, String> retornaMaisNovo;
        LocalDateTime data1, data2;

        retornaMaisNovo = listaDatasFormatadas.get(0);

        for (Map<String, String> dado : listaDatasFormatadas) {

            data1 = LocalDateTime.parse(retornaMaisNovo.get("nascimento"), padrao);
            data2 = LocalDateTime.parse(dado.get("nascimento"), padrao);

            if (data1.isBefore(data2)) {
                retornaMaisNovo = dado;
            }

        }
        return retornaMaisNovo;
    }

}

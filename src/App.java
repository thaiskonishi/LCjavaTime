import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    public List<Map<String, String>> formatarData(List<Map<String, String>> listaOriginal) {
        List<Map<String, String>> listaFormatada = new ArrayList<>();

        return listaFormatada;
    }

    public static void main(String[] args) throws Exception {
        List<Map<String, String>> original = new ArrayList<>();
        original.add(Map.of("nome", "João", "nascimento", "1985-12-11 12:10:33"));
        original.add(Map.of("nome", "Maria", "nascimento", "24-07-1988 23:02:41"));
        original.add(Map.of("nome", "Ana", "nascimento", "03:58:26 14-02-1983"));
        original.add(Map.of("nome", "Pedro", "nascimento", "08:03:07 1989-11-02"));

        List<Map<String, String>> listaFormatada = new ArrayList<>();

        for (Map<String, String> i : original) {

        }

        System.out.println(
                LocalDateTime.parse("1985-12-11 12:10:33", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("meu padrao: " + padrao.format(
                LocalDateTime.parse("1985-12-11 12:10:33", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

        System.out.println("acessando a lista original " + original.get(0).toString());
    }
}
// "^\\d{4}" regra é começa com 4 digitos
// ".*\\d{4}$" regra é acaba com 4 digitos
//
// String[] datas = new String[] { "1985-12-11 12:10:33", "24-07-1988 23:02:41",
// "03:58:26 14-02-1983",
// "08:03:07 1989-11-02" };
// for (String data : datas) {
// if(data.matches("^\\d{4}")){
// System.out.println(LocalDateTime.parse(data));
// }else{
// System.out.println(LocalDateTime.parse(data,
// DateTimeFormatter.ofPattern("dd//MM/yyyy")));
// }
// }

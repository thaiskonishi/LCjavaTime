## Enunciado

Nos anos 80 os nascimentos estavam sendo apontados a mão sem utilizar um padrão. Entretanto houve um processo de digitalização que ainda assim não foi adotado um padrão para as datas e continua tudo desformatado! Apesar da lista de nascimentos ser extensa foi detectado que há apenas 4 variações. Encontre uma resolução para processar estas datas de nascimento, onde:

    Não deve utilizar Stream.
    É obrigatório utilizar o Java Time.
    É preciso descobrir a pessoa mais velha e a mais nova.

    List<Map<String, String>> original = new ArrayList<>();
original.add(Map.of("nome", "João", "nascimento", "1985-12-11 12:10:33"));
original.add(Map.of("nome", "Maria", "nascimento", "24-07-1988 23:02:41"));
original.add(Map.of("nome", "Ana", "nascimento", "03:58:26 14-02-1983"));
original.add(Map.of("nome", "Pedro", "nascimento", "08:03:07 1989-11-02"));
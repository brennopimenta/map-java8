import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Artigo:   https://www.oracle.com/br/technical-resources/articles/java-stream-api.html

        // Transformando Lista em Stream
        /*
        List<String> items = new ArrayList<String>();
            items.add("um");
            items.add("dois");
            items.add("três");
            Stream<String> stream = items.stream();
        */

        //Tansformando MAP em Stream
        /*
        Map <String, String> map = new HashMap<String, String>();
            map.put("key1", "abacate");
            map.put("key2", "melancia");
            map.put("key3", "manga");
            Stream<String> stream = map.values().stream();
        */

        //Tansformando Valores ou Arrays em Stream
        /*
            Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4, 5);
            IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});
        */

        //Criando Stream de linhas apartir de um Arquivo io e pegando a quantidade de linhas do arquivo
        /*
            Stream <String> lines= Files.lines(Paths.get(“myFile.txt”),
            Charset.defaultCharset());
            long numbersLines = lines.count();
        */

        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        System.out.println("---// Usando ForEach Java 8 para imprimir todas as Pessoas da Lista---");
        pessoas.forEach(pessoa -> System.out.println("Nome: " + pessoa.nome + "  Nacionalidade: " + pessoa.getNacionalidade()));

        System.out.println("------------------------------------------");

        /** Filter */
        // Usando Stream e Filter - filtrar da lista as pessoas que nasceram no Brasil e colocar no Stream
        Stream<Pessoa> stream = pessoas.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));

        /** Collect */
        System.out.println("---// Usando ForEach Java 8 para imprimir apenas as Pessoas nacidas no Brasil- Apartir da Lista Filtrada---");
        // Convertendo o Stream ja filtrado em Lista novamente para trabalhar.
        List<Pessoa> listaFiltrada = stream.collect(Collectors.toList());
        listaFiltrada.forEach(pessoa -> System.out.println(pessoa.nome));


        System.out.println("---// Usando ForEach Java 8 para imprimir apenas as Pessoas nacidas no Brasil - Apartir da Lista---");
        // Podemos usar filtros apartir do metodo Stream sem a necessidade de conversão para Lista.
        pessoas.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).
                forEach(pessoa -> System.out.println(pessoa.nome));


        System.out.println("------// For antigo - antes do Java 8-----------------------");
        for(Pessoa pessoa : pessoas){
            if ( pessoa.getNacionalidade().equals("Brasil") )
                System.out.println(pessoa.nome);
        }

        System.out.println("------------------------------------------");

        /** Count */
        // COUNT - Usando Stream.Filter e Count - Contar as pessoas que nasceram no Brasil
        long quantPessoas = pessoas.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).count();
        System.out.println(quantPessoas);



        /** AllMatch */
        // AllMatch - Essa função verifica se todos os itens de uma lista atende um criterio, retornando Falso ou True - No Nosso Caso verifica se todas as pessoas são Brasileiras
        boolean todosBrasileiros = pessoas.stream().allMatch(pessoa -> pessoa.getNacionalidade().equals("Brasil"));
        System.out.println(todosBrasileiros);


    }
}

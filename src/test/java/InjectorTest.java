import injectors.Injector;
import org.junit.Test;
import repositories.Repository;
import services.CSVService;

public class InjectorTest {
    @Test
    public void injectRepository(){
        Repository repository = (new Injector().inject(new Repository()));
        System.out.println();
        System.out.println(repository);
    }

    @Test
    public void injectCSVLoader(){
        CSVService csvService = (new Injector().inject(new CSVService()));
        System.out.println();
        System.out.println(csvService);
    }
}

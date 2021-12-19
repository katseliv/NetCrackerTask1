import org.junit.Test;
import repositories.Repository;
import services.CSVService;

public class InjectorTest {
    private static final CSVService csvService = new CSVService();
    private static final Repository repository = new Repository();

    @Test
    public void injectRepository(){

    }

    @Test
    public void injectCSVLoader(){

    }
}

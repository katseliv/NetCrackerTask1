package injectors;

import annotations.AutoInjectable;
import annotations.Configuration;
import org.reflections.Reflections;
import repositories.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Configuration(packageName = {"entities", "repositories", "services"})
public class Injector {
    public <T> T inject(T object) throws IllegalAccessException, NoSuchMethodException {
        Class<?> clazz = object.getClass();
        Field[] declaresFields = clazz.getDeclaredFields();
        List<Field> annotatedFields = new ArrayList<>();

        Configuration configuration = getClass().getAnnotation(Configuration.class);
        String[] packageNames = configuration.packageName();

        for (Field field : declaresFields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                annotatedFields.add(field);
                if (!field.getType().isPrimitive()) {
                    for (String packageName : packageNames) {
                        Set<Class<?>> classes = new Reflections(packageName).getSubTypesOf(Object.class);
                        for (Class<?> packageClass : classes) {

                        }
                    }
                    System.out.println(field);
                } else if (!Collection.class.isAssignableFrom(field.getType())) {

                }
            }
        }

        System.out.println();
        annotatedFields.forEach(System.out::println);

//        Class<?> typeOfTheField = declaresFields[1].getType();
//        declaresFields[1].set(object, typeOfTheField);

        return object;
    }

    private Object findObjectInject(Class<?> typeOfTheField) {


        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Repository repository = (new Injector().inject(new Repository()));
        System.out.println(repository);
    }
}

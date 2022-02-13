package injectors;

import annotations.AutoInjectable;
import annotations.Configuration;
import exceptions.InjectionException;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import repositories.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Configuration(packageName = {"entities", "sorters", "services"})
public class Injector {
    public <T> T inject(T object) {
        Class<?> clazz = object.getClass();
        Field[] declaresFields = clazz.getDeclaredFields();

        Configuration configuration = getClass().getAnnotation(Configuration.class);
        String[] configurationPackageNames = configuration.packageName();

        try {
            for (Field field : declaresFields) {
                if (field.isAnnotationPresent(AutoInjectable.class)) {
                    Object objectToInject = findObjectToInject(field, configurationPackageNames);
                    if (objectToInject != null){
                        field.set(object, objectToInject);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return object;
    }

    private Object findObjectToInject(Field field, String[] configurationPackageNames) {
        try {
            if (!field.getType().isPrimitive() && !Collection.class.isAssignableFrom(field.getType())) {
                return findObjectToInjectAmongNoPrimitiveFields(field.getType(), configurationPackageNames);
            } else if (Collection.class.isAssignableFrom(field.getType())) {
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private Object findObjectToInjectAmongNoPrimitiveFields(Class<?> typeOfTheField, String[] configurationPackageNames) throws InjectionException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> classesToInject = new ArrayList<>();
        for (String packageName : configurationPackageNames) {
            Set<Class<?>> classes = new Reflections(packageName, new SubTypesScanner(false)).getSubTypesOf(Object.class);

            System.out.println(packageName);
            for (Class<?> packageClass : classes) {

                System.out.println(packageClass);
                if (typeOfTheField.isInterface()) {
                    if (!packageClass.equals(typeOfTheField) && typeOfTheField.isAssignableFrom(packageClass)) {
                        classesToInject.add(packageClass.getConstructor().newInstance());
                    }
                } else {
                    if (typeOfTheField.equals(packageClass)) {
                        System.out.println(typeOfTheField);
                        return packageClass.getConstructor().newInstance();
                    }
                }
            }
        }

        if (classesToInject.size() == 1) {
            return classesToInject.get(0);
        } else {
            throw new InjectionException("To much classes to inject");
        }

    }

}

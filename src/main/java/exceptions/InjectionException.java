package exceptions;

/**
 * Class exceptions.InjectionException
 * @author Ekaterina Selivanova
 **/
public class InjectionException extends Exception {
    /**
     * Constructor - creation new object without values
     **/
    public InjectionException() {
    }

    /**
     * Constructor - creation new object without values
     * @param message - message
     **/
    public InjectionException(String message) {
        super(message);
    }
}

package validators;

import enums.Status;

/**
 * Class validators.ValidationMessage
 * @author Ekaterina Selivanova
 **/
public class ValidationMessage {
    /**
     * Field status
     **/
    private Status status;
    /**
     * Field message
     **/
    private String message;

    /**
     * Constructor - creation new object with values
     * @param status - status of the validation
     * @param message - message of the validation
     **/
    public ValidationMessage(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Function getting status
     *
     * @return return status
     **/
    public Status getStatus() {
        return status;
    }

    /**
     * Function setting status
     *
     * @param status - status
     **/
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Function getting message
     *
     * @return return message
     **/
    public String getMessage() {
        return message;
    }

    /**
     * Function setting message
     *
     * @param message - message
     **/
    public void setMessage(String message) {
        this.message = message;
    }
}

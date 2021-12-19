package validators;

import entities.Contract;

/**
 * Interface validators.IValidator
 * @author Ekaterina Selivanova
 **/
public interface IValidator {
    /**
     * Function validating contract
     *
     * @param contract - contract
     **/
    ValidationMessage validate(Contract contract);
}

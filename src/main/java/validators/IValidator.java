package validators;

import entities.Contract;

public interface IValidator {

    ValidationMessage validate(Contract contract);

}

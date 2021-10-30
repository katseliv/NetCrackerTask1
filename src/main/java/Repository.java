public class Repository {
    private static Contract[] contracts = new Contract[100];
    private static int numberOfContracts = 0;

    public static Contract getContract(int id) {
        for (Contract contract : contracts) {
            if (contract != null && contract.getId() == id) {
                return contract;
            }
        }
        return null;
    }

    public static void addContract(Contract contract) {
        numberOfContracts++;
        if (numberOfContracts > contracts.length) {
            expandArray();
        }
        contracts[numberOfContracts - 1] = contract;
    }

    public static void deleteContract(int id) {
        numberOfContracts--;
        shiftArrayValues(id);
    }

    private static void expandArray() {
        Contract[] temp = contracts.clone();
        contracts = new Contract[contracts.length * 2];
        System.arraycopy(temp, 0, contracts, 0, contracts.length);
    }

    private static void shiftArrayValues(int id) {
        int start = findValue(id);
        if (start == -1){
            return;
        }

        for (int i = start; i < numberOfContracts + 1; i++) {
            contracts[id] = contracts[id + 1];
        }
    }

    private static int findValue(int id) {
        for (int i = 0; i < contracts.length; i++) {
            if (contracts[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void printContracts(){
        System.out.println("Contracts {");
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println(contracts[i]);
        }
        System.out.println("}");
    }
}

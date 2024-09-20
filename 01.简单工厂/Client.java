public class Client {
    public static void main(String[] args) {
        Operation oper = OperationFactory.createOperate("+");
        oper.setNumberA = 1;
        oper.setNumberB = 2;
        double res = oper.getResult();
    }
}

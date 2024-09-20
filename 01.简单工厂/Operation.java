class Operation {
    protected double numberA;
    protected double numberB;
    public double getResult() {
        return 0.0;
    }


}

class OperationAdd extends Operation {
    @Override
    public double getResult() {
        double res = numberA + numberB;
        return res;
    }
}
class OperationSub extends Operation {
    @Override
    public double getResult() {
        double res = numberA - numberB;
        return res;
    }

}

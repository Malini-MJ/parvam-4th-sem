public class BadVendingMachine {
    public double totalCashInMachine;
    public int productStock;
    private int pin;

    public static void main(String[] args) {
        BadVendingMachine machine = new BadVendingMachine();
        machine.totalCashInMachine = 5000.0;
        machine.productStock = 50;
        machine.pin = 5132;

        System.out.println("Cash: Rs." + machine.totalCashInMachine);
        System.out.println("Stock: " + machine.productStock);

        machine.totalCashInMachine = 0.0;
        machine.productStock = -99;
        machine.pin = 5132;

        System.out.println("Cash Left: Rs." + machine.totalCashInMachine);
        System.out.println("Stock Left: " + machine.productStock);
    }
}

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        
        Duck rubber = new RubberDuck();
        rubber.performQuack();
        rubber.performFly();

        Duck decoy = new DecoyDuck();
        decoy.performQuack();
        decoy.performFly();
    }
}

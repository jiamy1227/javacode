package javaee.Polymorphism;

public class Test {
    public static void main(String[] args) {
        AbstractTest at1 = new AbstractTestEx();
        AbstractTest at2 = new AbstractTestEx2();
        AbstractTest at3 = new AbstractTestEx3();
        at2.run();

        InterfaceTest interfaceTest = new InterfaceImp();
        interfaceTest.run();
        System.out.println(InterfaceTest.name);
    }
}

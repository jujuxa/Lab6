public class MyClass {
    public void publicMethod1() {
        System.out.println("Публичный метод 1");
    }

    public void publicMethod2() {
        System.out.println("Публичный метод 2");
    }


    @Repeat(times = 2)
    protected void protectedMethod1() {
        System.out.println("Защищённый метод 1");
    }

    protected void protectedMethod2() {
        System.out.println("Защищённый метод 2");
    }


    @Repeat(times = 2)
    private void privateMethod1(String msg) {
        System.out.println("Приватный метод 1: " + msg);
    }

    @Repeat(times = 4)
    private void privateMethod2(int number) {
        System.out.println("Приватный метод 2: " + number);
    }
}
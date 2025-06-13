class Singleton {
    private static Singleton instance;
    public final String value;

    public Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }

        return instance;
    }
}

public class NaiveSingletonExample {
    public static void main(String[] args) {
        Singleton singletonInstance = Singleton.getInstance("foo");
        System.out.println(singletonInstance.value);

        Singleton secondSingletonInstance = Singleton.getInstance("bar");
        System.out.println(secondSingletonInstance.value);

        // mali dodatak
        System.out.println(singletonInstance);
        System.out.println(secondSingletonInstance);
    }
}

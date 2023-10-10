package singleton_design_pattern;

class SingletonEager // SingletonEager is a class
{
    private static SingletonEager instance = new SingletonEager();
    private SingletonEager()  // Private constructor to prevent external instantiation.
    {
    }

    public static SingletonEager getInstance()// Static method to provide a single instance of SingletonEager
    {
        return instance;
    }
}

class Singleton { // Singleton is a class
    private static Singleton instance;

    private Singleton() // Private constructor to prevent external instantiation.
    {
    }

    public static Singleton getInstance() // Static method to provide a single instance of Singleton
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonSynchronizedMethod // SingletonSynchronizedMethod is a class
{
    private static SingletonSynchronizedMethod instance;
    private SingletonSynchronizedMethod()// Private constructor to prevent external instantiation.
    {

    }

    public static synchronized SingletonSynchronizedMethod getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized // SingletonSynchronized is a class
{
    private static SingletonSynchronized instance;
    private SingletonSynchronized()// Private constructor to prevent external instantiation.
    {

    }

    public static SingletonSynchronized getInstance()
    {
        if(instance == null)
        {
            synchronized (SingletonSynchronized.class)
            {
                if(instance == null)
                {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern
{
    public static void main(String[] args)// In the main, we created and used instances of different Singleton patterns
    {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}

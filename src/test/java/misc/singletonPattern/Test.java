package misc.singletonPattern;

public class Test {


    public static void main(String[] args) {


        // Non-singleton initialization
        Cat cat = new Cat(2);
        Cat cat2 = new Cat(2);
        Cat cat3 = new Cat(2);

        System.out.println(cat);
        System.out.println(cat2);
        System.out.println(cat3);
         // Singleton initialization
        System.out.println("----------------------");
        Cat cat4 = CatInitializer.getCat();
        Cat cat5 = CatInitializer.getCat();
        Cat cat6 = CatInitializer.getCat();

        System.out.println(cat4);
        System.out.println(cat5);
        System.out.println(cat6);

    }
}

package misc.singletonPattern;

public class CatInitializer {

    private static Cat cat;

    private CatInitializer(){}


    public static Cat getCat(){

        if(cat == null){
            cat = new Cat(2);
        }
        return cat;
    }
}

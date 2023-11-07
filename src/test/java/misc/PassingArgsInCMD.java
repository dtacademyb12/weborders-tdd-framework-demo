package misc;

public class PassingArgsInCMD {


    public static void main(String[] args) {

  // built in system properties
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));

        // we can set our own system property

//        System.setProperty("browser", "opera");
        // Whenever you pass an -D option through CMD, -D browser=opera
        // it is equivalent of setting a system property

        System.out.println(System.getProperty("browser"));


    }
}

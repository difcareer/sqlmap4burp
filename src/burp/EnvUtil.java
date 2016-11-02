package burp;

/**
 * Created by liushuqing on 16/11/2.
 */
public class EnvUtil {

    private static String OS_NAME = System.getProperties().getProperty("os.name").toUpperCase();

    /**
     * if local env is windows(true) or linux(false)
     *
     * @return
     */
    public static boolean isWindows() {
        System.out.println("local env is:" + OS_NAME);
        if (OS_NAME.contains("WINDOW")) {
            System.out.println("local env is windows");
            return true;
        } else {
            System.out.println("local env is linux");
        }
        return false;
    }
}

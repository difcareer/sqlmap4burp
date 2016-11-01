package burp;

/**
 * Created by liushuqing on 16/11/2.
 */
public class EnvUtil {
    /**
     * if local env is windows(true) or linux(false)
     * @return
     */
    public static boolean isWindows(){
            boolean flag = false;
            if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
                System.out.println("local env is windows");
                flag = true;
            }else {
                System.out.println("local env is linux");
            }
            return flag;
    }
}

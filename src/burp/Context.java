package burp;

import java.util.Properties;

/**
 * Created by wm on 2014/9/25.
 */
public class Context {

    public static Properties properties = System.getProperties();

    public final static String tempDir = (String) properties.get("java.io.tmpdir");

    public static String tempReqName = null;

    public static String tempBatName = null;

    public static String userConfig = null;

    public static String getTempReqName(boolean reGet) {
        if (tempReqName == null || reGet) {
            long ms = System.currentTimeMillis();
            tempReqName = tempDir + "/" + ms + ".req";
        }
        return tempReqName;
    }

    public static String getTempBatName(boolean reGet){
        if (tempBatName == null || reGet) {
            long ms = System.currentTimeMillis();
            tempBatName = tempDir + "/" + ms + ".bat";
        }
        return tempBatName;
    }

}

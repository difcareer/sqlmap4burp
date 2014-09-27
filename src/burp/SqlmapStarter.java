package burp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wm on 2014/9/25.
 */
public class SqlmapStarter implements Runnable {


    @Override
    public void run() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("sqlmap.py -r " + Context.getTempReqName(false));
            if (StringUtils.isNoneBlank(Context.userConfig)) {
                sb.append(" " + Context.userConfig);
            }
            File batFile = new File(Context.getTempBatName(true));
            if (!batFile.exists()) {
                batFile.createNewFile();
            }
            FileUtils.writeByteArrayToFile(batFile, sb.toString().getBytes());
            Runtime.getRuntime().exec("cmd /c start " + Context.getTempBatName(false));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        new Thread(new SqlmapStarter()).start();
        Properties properties = System.getProperties();
        System.out.println(properties.get("java.io.tmpdir"));
    }
}

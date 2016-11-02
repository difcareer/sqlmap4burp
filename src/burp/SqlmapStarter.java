package burp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
            boolean isWindows= EnvUtil.isWindows();
            String command="/bin/sh " + Context.getTempBatName(false);
            if(isWindows){
                command="cmd /c start " + Context.getTempBatName(false);
            }
            System.out.println("use command: " + command);
            Process process = Runtime.getRuntime().exec(command);
            InputStreamReader ir = new
                    InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader (ir);
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("**----sqlMap finish!!!----**");
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

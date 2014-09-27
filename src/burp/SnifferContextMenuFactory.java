package burp;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wm on 2014/9/24.
 */
public class SnifferContextMenuFactory implements IContextMenuFactory {

    IExtensionHelpers helpers;

    public SnifferContextMenuFactory(IExtensionHelpers helpers){
        this.helpers = helpers;
    }


    @Override
    public List<JMenuItem> createMenuItems(final IContextMenuInvocation invocation) {
        List<JMenuItem> list = new ArrayList<JMenuItem>();
        JMenuItem jMenuItem = new JMenuItem("send to Sqlmap");
        list.add(jMenuItem);
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IHttpRequestResponse[] messages = invocation.getSelectedMessages();
                byte[] req = messages[0].getRequest();
                File file = new File(Context.getTempReqName(true));
                try {
                    FileUtils.writeByteArrayToFile(file,req);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                new Thread(new SqlmapStarter()).start();

            }
        });
        return list;
    }

}

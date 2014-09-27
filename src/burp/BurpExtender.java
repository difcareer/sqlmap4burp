package burp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: latershow
 * Date: 14-8-23
 * Time: 下午4:53
 */
public class BurpExtender implements IBurpExtender, ITab, IHttpListener {

    private IExtensionHelpers helpers;
    private JPanel mainPanel;

    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
        this.helpers = callbacks.getHelpers();

        callbacks.registerContextMenuFactory(new SnifferContextMenuFactory(this.helpers));

        callbacks.setExtensionName("Sqlmap");
        callbacks.registerHttpListener(this);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainPanel = new JPanel();
                final JTextArea config = new JTextArea();
                config.setRows(10);
                config.setColumns(100);
                final JButton submit = new JButton("save");
                mainPanel.add(config);
                mainPanel.add(submit);
                callbacks.customizeUiComponent(submit);
                callbacks.customizeUiComponent(config);
                callbacks.customizeUiComponent(mainPanel);
                callbacks.addSuiteTab(BurpExtender.this);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Context.userConfig = config.getText();
                        submit.setText("saved...");
                    }
                });
            }
        });
    }

    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {

    }

    @Override
    public String getTabCaption() {
        return "Sqlmap";
    }

    @Override
    public Component getUiComponent() {
        return mainPanel;
    }
}

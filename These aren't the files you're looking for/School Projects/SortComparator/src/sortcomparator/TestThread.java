/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import View.BackupView;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mathieu
 */
public class TestThread implements Runnable {

    BackupView _panel;

    public TestThread(BackupView panel) {
        _panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            _panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

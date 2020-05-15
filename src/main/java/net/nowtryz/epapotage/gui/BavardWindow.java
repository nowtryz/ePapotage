package net.nowtryz.epapotage.gui;

import net.nowtryz.epapotage.entity.Bavard;
import net.nowtryz.epapotage.entity.Concierge;
import net.nowtryz.epapotage.entity.PapotageListener;
import net.nowtryz.epapotage.event.OffLineBavardEvent;
import net.nowtryz.epapotage.event.OnLineBavardEvent;
import net.nowtryz.epapotage.event.PapotageEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BavardWindow extends JFrame implements PapotageListener {
    private static final Dimension DIMENSION = new Dimension(300, 500);
    private Bavard bavard;
    // Components
    private JTextArea textArea = new JTextArea();
    private JPanel messagesPan = new JPanel();


    public BavardWindow(@NotNull Bavard bavard) {
        this.bavard = bavard;
        this.bavard.connect();

        BoxLayout messagesLayout = new BoxLayout(this.messagesPan, BoxLayout.Y_AXIS);
        this.messagesPan.setLayout(messagesLayout);

        this.setSize(BavardWindow.DIMENSION);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowListener());
        this.setTitle("Bavard - " + bavard.getUsername());
        this.add(this.createTextBox(), BorderLayout.SOUTH);
        this.add(messagesPan);

        Concierge.getInstance().registerListener(this);
        this.setVisible(true);
    }

    private Component createTextBox() {
        JPanel pan = new JPanel(new BorderLayout());
        JButton send = new JButton("Envoyer");
        pan.add(send, BorderLayout.EAST);
        pan.add(this.textArea);
        send.addActionListener(new SendListener());
        return pan;
    }

    @Override
    public void onPapotageEvent(PapotageEvent event) {
        this.messagesPan.add(new JLabel(String.format(
                "%s %s: %s",
                event.getFormattedDate(),
                event.getSource().equals(bavard) ? "Moi": event.getSource().getUsername(),
                event.getText()
        )));
        this.revalidate();
    }

    @Override
    public void onJoinEvent(OnLineBavardEvent event) {
        this.messagesPan.add(new JLabel(String.format(
                "%s a rejoint le tchat.",
                event.getSource().getUsername()
        )));
        this.revalidate();
    }

    @Override
    public void onLeaveEvent(OffLineBavardEvent event) {
        this.messagesPan.add(new JLabel(String.format(
                "%s a quitté le tchat.",
                event.getSource().getUsername()
        )));
        this.revalidate();
    }

    public class SendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bavard.dispatchMessage(textArea.getText());
            textArea.setText("");
        }
    }

    public class WindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            bavard.disconnect();
            Concierge.getInstance().unregisterListener(BavardWindow.this);
        }
    }
}

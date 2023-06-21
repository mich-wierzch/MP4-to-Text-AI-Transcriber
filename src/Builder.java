import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Builder extends JFrame {
    private JTextField getUrl;
    private JButton sendRequestButton;
    private JTextArea displayText;
    private JPanel Panel;
    private JProgressBar progressBar1;
    private JTextField api_Field;
    private JButton getInstructions;
    private JScrollPane scrollPanel;
    boolean isError;
    public Builder(){
        setContentPane(Panel);
        setTitle("AI Transcriber");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        Color initialBackgroundColor = progressBar1.getBackground();
        sendRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        progressBar1.setBackground(initialBackgroundColor);
                        Transcript transcript = new Transcript();
                        String url = getUrl.getText();
                        String api_Key = api_Field.getText();
                        if (url.isEmpty() || api_Key.isEmpty()){
                            displayText.setText("You need to enter both fields first!");
                            isError = true;
                            return null;
                        }
                        isError = false;
                        transcript.setAudio_url(url);
                        Gson gson = new Gson();
                        String jsonRequest = gson.toJson(transcript);
                        transcript.setAudio_url(jsonRequest);
                        try {
                            displayText.setText("Processing your request...");
                            API api = new API(transcript.getAudio_url(), transcript, api_Key);
                            displayText.setText(api.transcriptedAudio);
                            displayText.setSelectionStart(0);
                            displayText.setSelectionEnd(0);
                        } catch (IOException | URISyntaxException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        } catch (RuntimeException ex){
                            displayText.setText("There was an error while processing your request");
                            isError = true;
                        }

                        return null;
                    }

                    @Override
                    protected void done() {
                        progressBar1.setIndeterminate(false);
                        if (isError) {
                            progressBar1.setBackground(Color.RED);
                        } else {
                            progressBar1.setBackground(Color.GREEN);
                        }

                    }
                };
                progressBar1.setIndeterminate(true);
                worker.execute();
            }
        });
        getInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar1.setBackground(initialBackgroundColor);
                displayText.setText("""
                        In order to get this program to work you will need the following:
                        1. A .mp4 file that's stored somewhere online like a github repository - you can use test samples provided in this program's repository.
                        2. API Key from assemblyai.com - you can register for a free trial without any obligations.
                        Free trial gives you 5 hours worth of credit per month. That means you can transcribe up to 5 hours worth of mp4 files.
                        - The program will not work if any of the fields are empty.
                        - The program will return an error if the url or API Key provided are wrong.
                       """);
                displayText.setSelectionStart(0);
                displayText.setSelectionEnd(0);
            }
        });
    }
}

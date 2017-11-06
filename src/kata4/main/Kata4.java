package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    private String fileName;
    private Histogram<String> histogram;
    private List<Mail> mailList;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.execute();
    }
    
    public void input() throws IOException {
        fileName = "C:Documents\\NetBeansProjects\\Kata4\\emailsfile.txt";
        mailList = MailListReader.read(fileName);
    }
    
    public void process() {
         histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    public void execute() throws IOException {
        input();
        process();
        output();
    }
}
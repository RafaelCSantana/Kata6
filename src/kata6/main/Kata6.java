package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    private String fileName;
    private Histogram<String> histogram;
    private List<Mail> mailList;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    public void input() throws IOException {
        fileName = "C:\\Users\\RafaelCS\\Documents\\NetBeansProjects\\Kata6\\emailsfile.txt";
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
package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    private String fileName = "";
    private List<Mail> mailList;
    private HistogramBuilder<Mail> builder;
    Histogram<String> domains;
    Histogram<Character> letters;
    
    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    public void input() throws IOException {
        fileName = "C:\\Users\\RafaelCS\\Documents\\NetBeansProjects\\Kata6\\emailsfile.txt";
        mailList = MailListReader.read(fileName);
    }
    
    public void process() {
        builder = new HistogramBuilder<>(mailList);
        domains = builder.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        
        
        letters = builder.build(new Attribute<Mail,Character>(){
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
    }
    
    public void output() {
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer Caracter").execute();
    }
    
    public void execute() throws IOException {
        input();
        process();
        output();
    }
}
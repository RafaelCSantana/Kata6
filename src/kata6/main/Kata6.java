package kata6.main;

import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;

public class Kata6 {

    private String fileName = "";
    private List<Person> people;
    private HistogramBuilder<Person> builderPerson;
    Histogram<Character> gender;
    Histogram<Float> weight;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    public void input() throws ClassNotFoundException, SQLException {
        fileName = "C:\\Users\\RafaelCS\\Documents\\NetBeansProjects\\Kata6\\KATA.sDB";
        people = DataBaseList.read(fileName);
    }
    
    public void process() {
        builderPerson = new HistogramBuilder<>(people);
        gender = builderPerson.build(new Attribute<Person, Character>(){
            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });
        
        
        weight = builderPerson.build(new Attribute<Person,Float>(){
            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });
        
    }
    
    public void output() {
        new HistogramDisplay(gender, "Genero").execute();
        new HistogramDisplay(weight, "Peso").execute();
    }
    
    public void execute() throws ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
}
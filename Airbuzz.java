/**
 * Write a description of class Airbuzz here.
 * 
 * @author (Armin-Rafael Zdroba-Fisteag) 
 * @version (who even cares about this?)
 */

// Es wird eine Airbus A380-800 gebaut :D
public class Airbuzz
{
    private String name;
    private double eigengewicht;
    private Person pilot;
    private Person copilot;
    private Person cabinCrew;
    private Person passagier;
    
    public static void Airbuzz () {
        int[] sitze = new int[867]; // (Passangers + Cabin Crew = 863) + Pilots = 867
    }
    
    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Airbuzzname darf nicht null sein");
        }
        this.name = name;
    }
    
    public void setEigengewicht(double eigengewicht) {
        if (eigengewicht < 366000 || eigengewicht > 575000){
            throw new IllegalArgumentException("Eigengewicht nur zwischen 366000 und 575000 möglich");
        }
        this.eigengewicht = eigengewicht;
    }
    
    public Airbuzz () {
        this.setName("Airbus A380-800");
        this.setEigengewicht(575000); 
    }
    
    public Airbuzz (String name, double eigengewicht) {
        this.setName(name);
        this.setEigengewicht(eigengewicht);
    }
    
    public String getName(){
        return name;
    }
    
    public double getEigengewicht(){
        return eigengewicht;
    }
    
    public boolean personImAirbuzz (Person person) {
        boolean anwesend = true;
        if (person == pilot){
            return true;
        }
        else if (person == copilot){
            return true;
        }
        else if (person == cabinCrew){
            return true;
        }
        else if (person == passagier) {
            return true;
        }
        else return false;
    }
    
    // Einsteige Funktion
    public void board(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (personImAirbuzz(person) == true){
            throw new IllegalArgumentException("Person im Auto");
        }
        if (this.pilot == null){
            this.pilot = person;
            System.out.println(pilot.getName() + " ist der Fahrer");
        }
        else if (this.copilot == null){
            this.copilot = person;
            System.out.println(copilot.getName() + " ist der Beifahrer");
        }
        else if (this.cabinCrew == null){
            this.cabinCrew = person;
            System.out.println(cabinCrew.getName() + " ist auf der Rückbank");
        }
        else if (this.passagier == null){
            this.passagier = person;
            System.out.println(passagier.getName() + " ist auf der Rückbank");
        }
        else throw new IllegalStateException("Airbuzz ist voll");
    }
    
    // Aussteiger und Aussteige Funktion per Person
    private void aussteigenPilot() {
        System.out.println(pilot.getName() + " steigt aus");
        pilot = null;
    }
    private void aussteigenCopilot() {
        System.out.println(copilot.getName() + " steigt aus");
        copilot = null;
    }
    private void aussteigenCabinCrew() {
        System.out.println(cabinCrew.getName() + " steigt aus");
        cabinCrew = null;
    }
    private void aussteigenPassagier() {
        System.out.println(passagier.getName() + " steigt aus");
        passagier = null;
    }
    
    public void aussteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (personImAirbuzz (person) == false){
            throw new IllegalArgumentException("Person ist nicht im Auto");
        }
        if (this.pilot == person){
            aussteigenPilot();
        }
        else if (this.copilot == person){
            aussteigenCopilot();
        }
        else if (this.cabinCrew == person){
            aussteigenCabinCrew();
        }
        else if (this.passagier == person){
            aussteigenPassagier();
        }
        else throw new IllegalArgumentException("Keine Person im Airbuzz");
    }
    
    // Austeige Funktion per Name
    public void aussteigen(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht 'null' sein");
        }
        if (this.pilot != null && name.equals(pilot.getName())){
            aussteigenPilot();
        }
        else if (this.copilot != null && name.equals(copilot.getName())){
            aussteigenCopilot();
        }
        else if (this.cabinCrew != null && name.equals(cabinCrew.getName())){
            aussteigenCabinCrew();
        }
        else if (this.passagier != null && name.equals(passagier.getName())){
            aussteigenPassagier();
        }
        else throw new IllegalArgumentException("Person mit diesem Namen (" + name + ") ist nicht im Airbuzz");
    }
    
    // Gesamt Gewicht des Autos ausrechnen
    public double gesamtGewicht(){
        double gesamtGewicht = getEigengewicht(); 
        if (this.pilot != null){
            gesamtGewicht += this.pilot.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.copilot != null){
            gesamtGewicht += this.copilot.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.cabinCrew != null){
            gesamtGewicht += this.cabinCrew.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.passagier != null){
            gesamtGewicht += this.passagier.getKg();
            System.out.println(gesamtGewicht);
        }
        return gesamtGewicht;
    }
    
    
    public void autoAushalten(){
        if (gesamtGewicht() > 3500){
            throw new IllegalArgumentException("Auto hält das nicht aus");
        }
        System.out.println("Auto hält das Gewicht aus");
    }
    
    // Print Auto Infos
    public void printAuto(){
        System.out.println("Auto: " + name + ", Eigengewicht: " + eigengewicht);
        System.out.println("--------------------------------------------------------");
        
        System.out.print("Kapitän: ");
        if (this.pilot == null){
            System.out.println("--frei--");
        }
        else this.pilot.printPerson();
        System.out.println("---------");
        System.out.println("First Officer (Flap operator): ");
        if (this.copilot == null){
            System.out.println("--frei--");
        }
        else this.copilot.printPerson();
        System.out.println("---------");
        System.out.println("Cabin Crew: ");
        if (this.cabinCrew == null){
            System.out.println("--frei--");
        }
        else this.cabinCrew.printPerson();
        System.out.println("---------");
        System.out.println("Passagiere: ");
        if (this.passagier == null){
            System.out.println("--frei--");
        }
        else this.passagier.printPerson();
        System.out.println("---------");
        System.out.println("Das Gesamtgewicht: " + gesamtGewicht());
        autoAushalten();
        System.out.println("--------------------------------------------------------");
    }
}
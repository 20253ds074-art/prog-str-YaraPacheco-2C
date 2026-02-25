public class Perro extends Animal{

    public Perro(String name) {
        super(name);
    }

    @Override
    public void hacerSonido() {
        System.out.println(name+" Hace gua!");
    }
    public void marcarTerritorio(){
        System.out.println(name+" Esta alzando la patita");
    }
}

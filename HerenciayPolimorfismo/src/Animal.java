public class Animal {
    public Animal(String name) {
        this.name = name;
    }

    protected String name;//para hacer herencia
    public void comer(){
        System.out.println("Está comiendo");
    }
    public void  hacerSonido(){
        System.out.println("Está haciendo un sonido x");
    }

}

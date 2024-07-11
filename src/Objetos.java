public class Objetos {
    String placa;
    String marca;
    int cilindros;
    String combutible;
    String color;
    String propietario;

    public Objetos() {
    }

    public Objetos(String marca, String placa, int cilindros, String combutible, String color, String propietario) {
        this.marca = marca;
        this.placa = placa;
        this.cilindros = cilindros;
        this.combutible = combutible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindros() {
        return cilindros;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public String getCombutible() {
        return combutible;
    }

    public void setCombutible(String combutible) {
        this.combutible = combutible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}

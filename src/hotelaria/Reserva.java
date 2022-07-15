
package hotelaria;


public class Reserva {
    
    private Integer id;
    private Cliente cliente;
    private Estadia estadia;
    private Quartos quartos;

    public Reserva() {
        cliente = new Cliente();
        estadia = new Estadia();
        quartos = new Quartos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
    }

    
    
    
    
}
